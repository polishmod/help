package pl.mil.wp.help.room.entities.questionnaire;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

/**
 * Created by Sebastian Paciorek
 */
@Dao
public interface QuestionnaireDAO {

    @Query("SELECT * FROM questionnaire")
    List<Questionnaire> getAllQuestionnaires();

    @Query("SELECT * FROM questionnaire WHERE id IN (:questionnaireIds)")
    List<Questionnaire> loadAllByIds(int[] questionnaireIds);

    @Query("SELECT * FROM questionnaire WHERE id = (SELECT MAX(id) FROM questionnaire)")
    LiveData<Questionnaire> getNewestQuestionnaireByMaxId();

    @Query("SELECT * FROM questionnaire ORDER BY date DESC")
    LiveData<Questionnaire> getNewestQuestionnaireByDate();

    @Query("SELECT * FROM questionnaire ORDER BY date DESC")
    Questionnaire getNewestRawQuestionnaireByDate();

    @Query("SELECT * FROM questionnaire ORDER BY date ASC")
    LiveData<Questionnaire> getEldestQuestionnaireByDate();

    @Insert
    void insertQuestionnaires(Questionnaire... questionnaires);

    @Update
    void updateQuestionnaires(Questionnaire... questionnaires);

    @Delete
    void deleteQuestionnaires(Questionnaire... questionnaires);

    @Query("DELETE FROM questionnaire")
    void deleteAll();

    @Query("SELECT * FROM questionnaire")
    LiveData<List<Questionnaire>> getAllQuestionnaireLiveData();
}
