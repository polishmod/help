package pl.mil.wp.help.room;

import android.os.AsyncTask;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import pl.mil.wp.help.DatabaseProvider;
import pl.mil.wp.help.room.entities.location.Location;
import pl.mil.wp.help.room.entities.location.LocationDAO;
import pl.mil.wp.help.room.entities.questionnaire.Questionnaire;
import pl.mil.wp.help.room.entities.questionnaire.QuestionnaireDAO;

/**
 * Created by Sebastian Paciorek
 */
@Database(entities = {Location.class, Questionnaire.class}, version = 1)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;

    public static AppDatabase getDatabase() {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                   INSTANCE = DatabaseProvider.getInstance().getAppDatabase();
                   // UNCOMMENT FOR POPULATE DB ON START
                   // new PopulateDbAsync(INSTANCE).execute();
                }
            }
        }
        return INSTANCE;
    }

    public void clearDatabase() {
        if (INSTANCE != null) {
            new PopulateDbAsync(INSTANCE).execute();
        }
    }

    public abstract LocationDAO locationDAO();
    public abstract QuestionnaireDAO questionnaireDAO();

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {
        private final LocationDAO locationDAO;

        private final QuestionnaireDAO questionnaireDAO;

        public PopulateDbAsync(AppDatabase appDatabase) {
            this.locationDAO = appDatabase.locationDAO();
            this.questionnaireDAO = appDatabase.questionnaireDAO();
        }

        @Override
        protected Void doInBackground(Void... voids) {

            locationDAO.deleteAll();

            addExampleLocation();

            addExampleQuestionnaire();

            return null;
        }

        private void addExampleLocation(){
            Location location = new Location();

            location.latitude = 52.18;
            location.longitude = 21.37;
            location.accuracy = 15;
            location.speed = 10;
            location.date = DateFormat.getDateTimeInstance().format(new Date());

            locationDAO.insertLocations(location);
        }

        private void addExampleQuestionnaire(){
            Questionnaire questionnaire = new Questionnaire();

            questionnaire.firstQuestionAnswer = 3;
            questionnaire.secondQuestionAnswer = 2;
            questionnaire.thirdQuestionAnswer = 1;
            questionnaire.fourthQuestionAnswer = 3;
            questionnaire.fifthQuestionAnswer = new ArrayList<Integer>(){{
                add(1);
                add(2);
                add(4);
            }};
            questionnaire.sixthQuestionAnswer = 4;

            questionnaireDAO.insertQuestionnaires(questionnaire);
        }
    }

}
