package pl.mil.wp.help.ui.registration;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pl.mil.wp.help.AuthenticationActivity;
import pl.mil.wp.help.R;
import pl.mil.wp.help.connection.authentication.register.RegisterInterface;
import pl.mil.wp.help.connection.authentication.register.RegisterManager;
import pl.mil.wp.help.ui.sign_in.SignInFragment;

public class RegistrationFragment extends Fragment {

    private static final String TAG = RegistrationFragment.class.getSimpleName();

    private RegisterInterface registerManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_registration, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        registerManager = RegisterManager.getInstance();
        registerManager.setActivity(getActivity());
    }

    @OnClick({R.id.fab_facebook, R.id.fab_instagram})
    void notImplemented() {
        Toast.makeText(requireContext(), requireContext().getString(R.string.not_implemented_info), Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.fab_google)
    void goToGoogleSignIn() {

        AuthenticationActivity.getInstance().googleSignIn();
    }

    @OnClick(R.id.btn_sign_in)
    void goToSignInFragment() {
        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.auth_container, new SignInFragment());
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @OnClick(R.id.btn_email_registration)
    void goToRegistrationWithEmail() {
        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.auth_container, new RegisterWithEmailFragment());
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @OnClick(R.id.btn_anonymous_registration)
    void registerAnonymously() {
        registerManager.registerAnonymously();
    }
}