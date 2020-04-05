package pl.mil.wp.help.ui.coughrecording;

import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import pl.mil.wp.help.R;

public class CoughRecordingViewModel extends ViewModel {
    private static final int START_ICON = R.drawable.ic_play;
    private static final int STOP_ICON =  R.drawable.ic_stop;
    private static final int RETAKE_ICON =  R.drawable.ic_repeat;


    public static final int RECORDER_IDLE = 0;
    public static final int RECORDER_RECORDING = 1;
    public static final int RECORDER_RECORDED = 2;
    public static final int RECORDER_PROCESSING = 3;

    private MutableLiveData<Integer> mState;
    private MediatorLiveData<Integer> mButtonIcon;
    private MediatorLiveData<Integer> mChartVisibility;
    private MediatorLiveData<Boolean> mNextButtonEnabled;
    private MediatorLiveData<Integer> mFabVisibility;
    private MediatorLiveData<Integer> mProcessingVisibility;

    public CoughRecordingViewModel() {
        mState = new MutableLiveData<>();
        mState.setValue(RECORDER_IDLE);
        mButtonIcon = new MediatorLiveData<>();
        mButtonIcon.addSource(mState, value ->
        {
            mButtonIcon.setValue(value == RECORDER_RECORDED ? RETAKE_ICON : value == RECORDER_RECORDING ? STOP_ICON : START_ICON);
        });
        mChartVisibility = new MediatorLiveData<>();
        mChartVisibility.addSource(mState, value ->
        {
            mChartVisibility.setValue(value == RECORDER_RECORDING ? View.VISIBLE : View.INVISIBLE);
        });

        mNextButtonEnabled = new MediatorLiveData<>();
        mNextButtonEnabled.addSource(mState, value ->
        {
            mNextButtonEnabled.setValue(value == RECORDER_RECORDED);
        });

        mFabVisibility = new MediatorLiveData<>();
        mFabVisibility.addSource(mState, value ->
        {
            mFabVisibility.setValue(value != RECORDER_PROCESSING ? View.VISIBLE : View.INVISIBLE);
        });

        mProcessingVisibility = new MediatorLiveData<>();
        mProcessingVisibility.addSource(mState, value ->
        {
            mProcessingVisibility.setValue(value == RECORDER_PROCESSING ? View.VISIBLE : View.INVISIBLE);
        });
    }

    public MutableLiveData<Integer> getState() {
        return mState;
    }
    public LiveData<Integer> getButtonIcon() {
        return mButtonIcon;
    }
    public LiveData<Integer> getChartVisibility() {
        return mChartVisibility;
    }
    public LiveData<Boolean> getNextButtonEnabled() {
        return mNextButtonEnabled;
    }
    public LiveData<Integer> getFabVisibility() {
        return mFabVisibility;
    }
    public LiveData<Integer> getProcessingVisibility() {
        return mProcessingVisibility;
    }
}