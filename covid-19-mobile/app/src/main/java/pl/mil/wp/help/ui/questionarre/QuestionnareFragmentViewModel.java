package pl.mil.wp.help.ui.questionarre;

import android.util.Log;
import android.view.View;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import pl.mil.wp.help.connection.questionnary.SymptomsSickPropabilityCalculator;
import pl.mil.wp.help.room.AppDatabaseManager;
import pl.mil.wp.help.room.AppDatabaseManagerInterface;
import pl.mil.wp.help.room.entities.questionnaire.Questionnaire;

public class QuestionnareFragmentViewModel extends ViewModel {
    private final static String TAG = QuestionnareFragmentViewModel.class.getSimpleName();
    private QuestionnareFragmentRepository repository = new QuestionnareFragmentRepository();
    private Map<Integer, Integer> temporaryDataAnswersInteger = new HashMap<>();
    private Map<Integer, List<Integer>> temporaryDataAnswersList = new HashMap<>();
    private MutableLiveData<Integer> currentPageNumber = new MutableLiveData<>();
    private MediatorLiveData<Integer> nextButtonVisibility = new MediatorLiveData<>();
    private MediatorLiveData<Integer> summaryButtonVisibility = new MediatorLiveData<>();
    private MutableLiveData<Boolean> shouldRunUploadManager = new MutableLiveData<>();

    private AppDatabaseManagerInterface appDatabaseManager;

    public double propability = 0;

    public QuestionnareFragmentViewModel() {
        nextButtonVisibility.addSource(currentPageNumber, value -> {
            nextButtonVisibility.setValue(value + 1 < QuestionnarePagesListProvider.PROVIDER_ITEMS_SIZE - 1 ? View.VISIBLE : View.GONE);
        });
        summaryButtonVisibility.addSource(currentPageNumber, value -> {
            summaryButtonVisibility.setValue(value + 1 == QuestionnarePagesListProvider.PROVIDER_ITEMS_SIZE - 1 ? View.VISIBLE : View.GONE);
        });
    }

    public void saveToTemporalStorage(int questionNumber, int value) {
        temporaryDataAnswersInteger.put(questionNumber, value);
    }

    void saveToTemporalStorage(int questionNumber, List<Integer> values) {
        temporaryDataAnswersList.put(questionNumber, values);
    }

    void clearQuestionnaryData() {
        temporaryDataAnswersInteger.clear();
        temporaryDataAnswersList.clear();
    }

    LiveData<Integer> getNextButtonVisibility() {
        return nextButtonVisibility;
    }

    LiveData<Integer> getSummaryButtonVisibility() {
        return summaryButtonVisibility;
    }


    void saveQuestionnaryData() {
        appDatabaseManager = AppDatabaseManager.getInstance();

        Questionnaire questionnaire = new Questionnaire();

        questionnaire.firstQuestionAnswer = temporaryDataAnswersInteger.get(1);
        questionnaire.secondQuestionAnswer = temporaryDataAnswersInteger.get(2);
        questionnaire.thirdQuestionAnswer = temporaryDataAnswersInteger.get(3);
        questionnaire.fourthQuestionAnswer = temporaryDataAnswersInteger.get(4);
        questionnaire.fifthQuestionAnswer = temporaryDataAnswersList.get(5);
        questionnaire.sixthQuestionAnswer = temporaryDataAnswersInteger.get(6);
        questionnaire.seventhQuestionAnswer = temporaryDataAnswersInteger.get(7);

        appDatabaseManager.saveNewQuestionnaireToDatabase(questionnaire);

        Log.d(TAG, "SAVED QUESTIONNAIRE");

        Log.i(TAG, "saveQuestionnaryData1: " + temporaryDataAnswersInteger.toString());
        Log.i(TAG, "saveQuestionnaryData2: " + temporaryDataAnswersList.toString());
        shouldRunUploadManager.postValue(true);

        propability = new SymptomsSickPropabilityCalculator().calculateProbability(temporaryDataAnswersList.get(5));
        Log.i(TAG, "saveQuestionnaryData: " + propability);
    }


    void setCurrentPageNumber(int pageNumber) {
        currentPageNumber.postValue(pageNumber);
    }

    LiveData<Boolean> shouldRunUploadManager() {
        return shouldRunUploadManager;
    }

}
