package pl.mil.wp.help.room;


import android.location.Location;

import pl.mil.wp.help.room.entities.questionnaire.Questionnaire;

/**
 * Created by Sebastian Paciorek
 */
public interface AppDatabaseManagerInterface {

    void saveNewLocationToDatabase(Location location);

    void saveNewQuestionnaireToDatabase(Questionnaire questionnaire);
}
