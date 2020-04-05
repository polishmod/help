package pl.mil.wp.help.room;

import android.annotation.SuppressLint;
import android.location.Location;
import android.os.AsyncTask;
import android.util.Log;

import java.text.DateFormat;
import java.util.Date;

import pl.mil.wp.help.DatabaseProvider;
import pl.mil.wp.help.room.entities.location.LocationDAO;
import pl.mil.wp.help.room.entities.questionnaire.Questionnaire;
import pl.mil.wp.help.room.entities.questionnaire.QuestionnaireDAO;


/**
 * Created by Sebastian Paciorek
 */
public class AppDatabaseManager implements AppDatabaseManagerInterface {

    private static final String TAG = AppDatabaseManager.class.getSimpleName();

    public static AppDatabaseManager appDatabaseManager;

    public static AppDatabaseManager getInstance() {
        if (appDatabaseManager == null) {
            synchronized (AppDatabaseManager.class) {
                if (appDatabaseManager == null) {
                    appDatabaseManager = new AppDatabaseManager();
                }
            }
        }
        return appDatabaseManager;
    }

    public AppDatabaseManager() {
    }

    @Override
    public void saveNewLocationToDatabase(Location location) {
        saveNewLocationToDatabase(convertToLocationEntity(location));
    }

    @SuppressLint("StaticFieldLeak")
    private void saveNewLocationToDatabase(pl.mil.wp.help.room.entities.location.Location location) {
        Log.i(TAG, "saveNewLocationToDatabase: " + location);
        //new InsertLocationAsync(AppDatabase.getDatabase(HelpApplication.getInstance()), location).execute();
        new InsertLocationAsync(DatabaseProvider.getInstance().getAppDatabase(), location).execute();
    }

    private pl.mil.wp.help.room.entities.location.Location convertToLocationEntity(android.location.Location location) {
        Log.i(TAG, "convertToLocationEntity: " + location);
        pl.mil.wp.help.room.entities.location.Location locationEntity = new pl.mil.wp.help.room.entities.location.Location();

        if (location != null) {
            locationEntity.latitude = location.getLatitude();
            locationEntity.longitude = location.getLongitude();
            locationEntity.accuracy = location.getAccuracy();
            locationEntity.speed = location.getSpeed();
        }
        return locationEntity;
    }

    private static class InsertLocationAsync extends AsyncTask<Void, Void, Void> {
        private final LocationDAO locationDAO;

        private pl.mil.wp.help.room.entities.location.Location location;

        public InsertLocationAsync(AppDatabase appDatabase, pl.mil.wp.help.room.entities.location.Location location) {
            Log.i(TAG, "InsertLocationAsync: ");
            this.locationDAO = appDatabase.locationDAO();
            this.location = location;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            Log.d(TAG, "insert location in progress...");
            locationDAO.insertLocations(location);
            return null;
        }
    }

    @Override
    public void saveNewQuestionnaireToDatabase(Questionnaire questionnaire) {
        new InsertQuestionnaireAsync(DatabaseProvider.getInstance().getAppDatabase(), questionnaire).execute();
    }

    private static class InsertQuestionnaireAsync extends AsyncTask<Void, Void, Void> {
        private final QuestionnaireDAO questionnaireDAO;

        private Questionnaire questionnaire;

        public InsertQuestionnaireAsync(AppDatabase appDatabase, Questionnaire questionnaire) {
            Log.i(TAG, "insertQuestionnaireAsync: ");
            this.questionnaireDAO = appDatabase.questionnaireDAO();
            this.questionnaire = questionnaire;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            Log.d(TAG, "insert questionnaire in progress...");
            questionnaireDAO.insertQuestionnaires(questionnaire);
            return null;
        }
    }
}
