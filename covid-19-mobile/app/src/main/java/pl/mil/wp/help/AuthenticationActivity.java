package pl.mil.wp.help;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import pl.mil.wp.help.API.models.AppUserViewModel;
import pl.mil.wp.help.API.models.AppUserViewModelApiResponse;
import pl.mil.wp.help.connection.RetrofitManager;
import pl.mil.wp.help.connection.apiusers.ApiUsersService;
import pl.mil.wp.help.connection.authentication.AuthResponse;
import pl.mil.wp.help.connection.authentication.AuthService;
import pl.mil.wp.help.connection.authentication.data.LoginAuthData;
import pl.mil.wp.help.firebase.interceptors.FCMInterceptor;
import pl.mil.wp.help.firebase.presenter.FirebasePresenter;
import pl.mil.wp.help.shared_preferences.SharedPreferencesUtil;
import pl.mil.wp.help.ui.registration.RegistrationFragment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class AuthenticationActivity extends AppCompatActivity {

    private static int GOOGLE_SIGN_IN_REQUEST_CODE = 9999;

    private static final String TAG = AuthenticationActivity.class.getSimpleName();

    private GoogleSignInClient googleSignInClient;

    private static AuthenticationActivity authenticationActivity;

    public static AuthenticationActivity getInstance() {
        return authenticationActivity;
    }

    public interface OnSignInFinished{
        void onFinish();
    }

    OnSignInFinished  onSignInFinished;

    public void setOnSignInFinished(OnSignInFinished onSignInFinished) {
        this.onSignInFinished = onSignInFinished;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        authenticationActivity = this;

        getWindow().setEnterTransition(null);
        setContentView(R.layout.activity_authentication);
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.auth_container, new RegistrationFragment());
        transaction.commit();
    }

    @Override
    public void finishAfterTransition() {
        finish();
    }

    public void signIn(String email, String password) {
        AuthService authService = RetrofitManager.buildService(AuthService.class);
        ApiUsersService apiUsersService = RetrofitManager.buildService(ApiUsersService.class);

        FirebaseInstanceId.getInstance().getInstanceId()
                .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                    @Override
                    public void onComplete(@NonNull Task<InstanceIdResult> task) {
                        if (!task.isSuccessful()) {

                            return;
                        }
                        FCMInterceptor.getInstance().setToken(Objects.requireNonNull(task.getResult()).getToken());

                        LoginAuthData loginAuthData = new LoginAuthData();
                        loginAuthData.setEmail(email);
                        loginAuthData.setFcmToken(FirebasePresenter.getInstance().getToken());
                        loginAuthData.setPassword(password);


                        authService.login(loginAuthData).enqueue(new Callback<AuthResponse>() {
                            @Override
                            public void onResponse(Call<AuthResponse> call, Response<AuthResponse> response) {
                                if (response.body() != null) {
                                    setAuthTokenSharedPreferences(response.body().getContent());
                                    setFirebaseCloudMessagingTokenSharedPreferences(FirebasePresenter.getInstance().getToken());
                                    Log.d(TAG, "set SharedPreferencesUtil TOKEN: " + SharedPreferencesUtil.getAuthToken(AuthenticationActivity.getInstance()));
                                    Toast.makeText(AuthenticationActivity.this, getString(R.string.login_success_info), Toast.LENGTH_SHORT).show();

                                    apiUsersService.getMyAccount("Bearer " + response.body().getContent()).enqueue(new Callback<AppUserViewModelApiResponse>() {
                                        @Override
                                        public void onResponse(Call<AppUserViewModelApiResponse> call, Response<AppUserViewModelApiResponse> response) {
                                            if (response.isSuccessful()) {
                                                if (response.body() != null && response.body().getContent() != null) {
                                                    AppUserViewModel appUserViewModel = response.body().getContent();

                                                    if (appUserViewModel.getUid() != null)
                                                        setUIDSharedPreferences(appUserViewModel.getUid());
                                                    if (appUserViewModel.getId() != null)
                                                        setIDUserSharedPreferences(Long.toString(appUserViewModel.getId()));
                                                }
                                                onSignInFinished.onFinish();
                                                goToMainActivity();
                                            } else {

                                                onSignInFinished.onFinish();

                                                Toast.makeText(AuthenticationActivity.this, getString(R.string.login_auth_problem_info), Toast.LENGTH_SHORT).show();

                                            }

                                        }

                                        @Override
                                        public void onFailure(Call<AppUserViewModelApiResponse> call, Throwable t) {

                                            onSignInFinished.onFinish();

                                            Toast.makeText(AuthenticationActivity.this, getString(R.string.login_failure_info), Toast.LENGTH_SHORT).show();

                                        }
                                    });

                                } else {

                                    onSignInFinished.onFinish();

                                    Toast.makeText(AuthenticationActivity.this, getString(R.string.login_invalid_credentials_info), Toast.LENGTH_SHORT).show();

                                }
                            }

                            @Override
                            public void onFailure(Call<AuthResponse> call, Throwable t) {

                                onSignInFinished.onFinish();

                                Toast.makeText(AuthenticationActivity.this, getString(R.string.login_failure_info), Toast.LENGTH_SHORT).show();

                            }
                        });
                    }
                });
    }

    public void googleSignIn() {
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.server_client_id))
                .requestEmail()
                .build();

        googleSignInClient = GoogleSignIn.getClient(this, gso);

        Intent signInIntent = googleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, GOOGLE_SIGN_IN_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.d(TAG, "REQUEST CODE: " + requestCode);

        if (requestCode == GOOGLE_SIGN_IN_REQUEST_CODE) {

            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
            if (account != null) {
                String idToken = account.getIdToken();

                Log.d(TAG, "account != null IDTOKEN: " + idToken);

                FirebaseInstanceId.getInstance().getInstanceId()
                        .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                            @Override
                            public void onComplete(@NonNull Task<InstanceIdResult> task) {
                                if (!task.isSuccessful()) {

                                    return;
                                }
                                FCMInterceptor.getInstance().setToken(Objects.requireNonNull(task.getResult()).getToken());
                                Log.d(TAG, "Firebase TOKEN in HandleSignResult" + FirebasePresenter.getInstance().getToken());
                                setAuthTokenSharedPreferences(idToken);
                                setFirebaseCloudMessagingTokenSharedPreferences(FirebasePresenter.getInstance().getToken());
                                loginWithGoogleOnBackend(account);

                                Log.d(TAG, "GOOGLE SIGNED IN SUCCESSFULLY");
                                goToMainActivity();
                            }
                        });

            } else {
                Log.d(TAG, "account == null ");
            }

        } catch (ApiException e) {
            Log.w(TAG, "GOOGLE SIGNED signInResult:failed code=" + e.getStatusCode());
            Toast.makeText(authenticationActivity, getString(R.string.google_sign_in_failure_name), Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        checkUserAlreadySignedInGoogle();
    }

    private void loginWithGoogleOnBackend(GoogleSignInAccount account) {
        String email = account.getEmail();
        String idToken = account.getIdToken();

        //TODO send request on server
    }

    private void checkUserAlreadySignedInGoogle() {
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);

        if (account != null) {
            Log.d(TAG, "USER IS ALREADY SIGNED IN WITH GOOGLE");
            goToMainActivity();
        } else {
            Log.d(TAG, "USER IS NOT SIGNED IN WITH GOOGLE");
        }
    }

    private void goToMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void setAuthTokenSharedPreferences(String idToken) {
        SharedPreferencesUtil.setAuthToken(this, idToken);
    }

    private void setUIDSharedPreferences(String uid) {
        SharedPreferencesUtil.setUID(this, uid);
    }

    private void setIDUserSharedPreferences(String idUser) {
        SharedPreferencesUtil.setIDUser(this, idUser);
    }

    private void setFirebaseCloudMessagingTokenSharedPreferences(String fcmToken) {
        SharedPreferencesUtil.setFirebaseCloudMessagingToken(this, fcmToken);
    }
}
