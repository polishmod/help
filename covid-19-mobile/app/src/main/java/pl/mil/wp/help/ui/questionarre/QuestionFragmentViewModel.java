package pl.mil.wp.help.ui.questionarre;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class QuestionFragmentViewModel extends ViewModel {
    private MutableLiveData<Integer> progress = new MutableLiveData<>(1);


    LiveData<Integer> getProgress() {
        return progress;
    }

    void updateProgress(int value) {
        progress.postValue(value);
    }
}
