package pl.mil.wp.help.ui.registration;

import android.text.Editable;
import android.text.TextWatcher;

public interface CustomTextWatcher extends TextWatcher {
    @Override
    default void beforeTextChanged(CharSequence s, int start, int count, int after){

    }

    @Override
    default void afterTextChanged(Editable s){

    }
}
