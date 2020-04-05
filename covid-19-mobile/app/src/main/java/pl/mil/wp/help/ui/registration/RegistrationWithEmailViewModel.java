package pl.mil.wp.help.ui.registration;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RegistrationWithEmailViewModel extends ViewModel {
    private MediatorLiveData<Boolean> btnEnabled = new MediatorLiveData<>();
    private MutableLiveData<String> password = new MutableLiveData<>();
    private MutableLiveData<String> repeatPassword = new MutableLiveData<>();
    private MutableLiveData<String> email = new MutableLiveData<>();

    public RegistrationWithEmailViewModel() {
        btnEnabled.addSource(password, value -> btnEnabled.postValue((shouldBeButtonEnabled())));
        btnEnabled.addSource(repeatPassword, value -> btnEnabled.postValue((shouldBeButtonEnabled())));
        btnEnabled.addSource(email, value -> btnEnabled.postValue((shouldBeButtonEnabled())));
    }

    private boolean shouldBeButtonEnabled() {
        if (password.getValue() == null || repeatPassword.getValue() == null || email.getValue() == null)
            return false;
        else {
            boolean isPasswordMatching = password.getValue().equals(repeatPassword.getValue());
            boolean isPasswordEmpty = password.getValue().isEmpty();
            boolean isEmailEmpty = email.getValue().isEmpty();
            return (isPasswordMatching && !isPasswordEmpty && !isEmailEmpty);
        }
    }

    LiveData<Boolean> getBtnEnabled() {
        return btnEnabled;
    }

    void updatePassword(String s) {
        password.postValue(s);
    }

    void updateRepeatPassword(String s) {
        repeatPassword.postValue(s);
    }

    void updateEmail(String s) {
        email.postValue(s);
    }
}
