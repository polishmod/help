package pl.mil.wp.help.ui.registration;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pl.mil.wp.help.AuthenticationActivity;
import pl.mil.wp.help.R;
import pl.mil.wp.help.connection.RetrofitManager;
import pl.mil.wp.help.connection.authentication.AuthResponse;
import pl.mil.wp.help.connection.authentication.AuthService;
import pl.mil.wp.help.connection.authentication.data.RegisterAuthData;
import pl.mil.wp.help.ui.sign_in.SignInFragment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterWithEmailFragment extends Fragment {
    private final static String TAG = RegisterWithEmailFragment.class.getSimpleName();
    private final int btnEnabledColorResourceId = R.color.colorPrimary;
    private final int btnDisabledColorResourceId = R.color.grey_D;

    private RegistrationWithEmailViewModel viewModel;

    @BindView(R.id.inputEmail)
    TextInputLayout emailInput;
    @BindView(R.id.inputPassword)
    TextInputLayout passwordInput;
    @BindView(R.id.inputRePassword)
    TextInputLayout reEnterPasswordInput;
    @BindView(R.id.btn_singup)
    MaterialButton btnSingUp;

    @BindView(R.id.tv_terms_and_policy)
    TextView tvTermsAndPolicy;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register_with_email, container, false);
        ButterKnife.bind(this, view);
        viewModel = new ViewModelProvider(this).get(RegistrationWithEmailViewModel.class);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel.getBtnEnabled().observe(getViewLifecycleOwner(), isEnabled -> {
            btnSingUp.setEnabled(isEnabled);
            if (isEnabled) {
                btnSingUp.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(requireContext(), btnEnabledColorResourceId)));
            } else {
                btnSingUp.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(requireContext(), btnDisabledColorResourceId)));
            }
        });


        passwordInput.getEditText().addTextChangedListener((CustomTextWatcher) (s, start, before, count) -> viewModel.updatePassword(s.toString()));
        reEnterPasswordInput.getEditText().addTextChangedListener((CustomTextWatcher) (s, start, before, count) -> viewModel.updateRepeatPassword(s.toString()));
        emailInput.getEditText().addTextChangedListener((CustomTextWatcher) (s, start, before, count) -> viewModel.updateEmail(s.toString()));
        setTermsAndPrivacyPolicyTextClickable();
    }

    @OnClick(R.id.fab_google)
    void goToGoogleSignIn() {

        AuthenticationActivity.getInstance().googleSignIn();
    }

    @OnClick(R.id.btn_singup)
    void register() {
        AuthService authService = RetrofitManager.buildService(AuthService.class);
        RegisterAuthData registerAuthData = new RegisterAuthData();
        registerAuthData.setEmail(emailInput.getEditText().getText().toString());
        registerAuthData.setPassword(passwordInput.getEditText().getText().toString());

        authService.register(registerAuthData).enqueue(new Callback<AuthResponse>() {
            @Override
            public void onResponse(Call<AuthResponse> call, Response<AuthResponse> response) {
                if (response.body() != null) {
                    goToLoginActivity();
                    Toast.makeText(requireContext(), getString(R.string.register_success_info), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(requireContext(), getString(R.string.register_response_not_successful_info), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<AuthResponse> call, Throwable t) {
                Toast.makeText(requireContext(), getString(R.string.register_failure_info), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setTermsAndPrivacyPolicyTextClickable() {
        SpannableString ss = new SpannableString(getString(R.string.agree_with_terms_and_policy_name));
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                Toast.makeText(requireContext(), getString(R.string.terms_and_policy_shown_info), Toast.LENGTH_SHORT).show();
            }
        };

        ss.setSpan(clickableSpan, 11, 35, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        tvTermsAndPolicy.setText(ss);
        tvTermsAndPolicy.setMovementMethod(LinkMovementMethod.getInstance());
        tvTermsAndPolicy.setHighlightColor(Color.TRANSPARENT);
    }

    private void goToLoginActivity() {
        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.auth_container, new SignInFragment());
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
