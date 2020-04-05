package pl.mil.wp.help.ui.sign_in;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.ybq.android.spinkit.SpinKitView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pl.mil.wp.help.AuthenticationActivity;
import pl.mil.wp.help.R;

public class SignInFragment extends Fragment {

    @BindView(R.id.btn_signin)
    MaterialButton btnSignIn;
    @BindView(R.id.input_email)
    TextInputLayout inputEmail;
    @BindView(R.id.input_password)
    TextInputLayout inputPassword;
    @BindView(R.id.progress_bar_login)
    SpinKitView progressBarLogin;
    @BindView(R.id.group_login)
    Group groupLogin;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AuthenticationActivity.getInstance().setOnSignInFinished(new AuthenticationActivity.OnSignInFinished() {
            @Override
            public void onFinish() {
                progressBarLogin.setVisibility(View.GONE);
                groupLogin.setVisibility(View.VISIBLE);
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign_in, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.btn_signin)
    void signIn() {
        progressBarLogin.setVisibility(View.VISIBLE);
        groupLogin.setVisibility(View.INVISIBLE);
        AuthenticationActivity.getInstance().signIn(inputEmail.getEditText().getText().toString(), inputPassword.getEditText().getText().toString());
    }

    @OnClick(R.id.fab_google)
    void goToGoogleSignIn() {
        AuthenticationActivity.getInstance().googleSignIn();
    }


}
