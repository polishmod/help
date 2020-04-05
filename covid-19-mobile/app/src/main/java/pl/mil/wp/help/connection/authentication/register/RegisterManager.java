package pl.mil.wp.help.connection.authentication.register;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

import java.util.Objects;

import androidx.annotation.NonNull;
import pl.mil.wp.help.API.models.AppUserViewModel;
import pl.mil.wp.help.API.models.AppUserViewModelApiResponse;
import pl.mil.wp.help.MainActivity;
import pl.mil.wp.help.R;
import pl.mil.wp.help.connection.RetrofitManager;
import pl.mil.wp.help.connection.apiusers.ApiUsersService;
import pl.mil.wp.help.connection.authentication.AuthResponse;
import pl.mil.wp.help.connection.authentication.AuthService;
import pl.mil.wp.help.connection.authentication.RegisterAnonymousAuthResponse;
import pl.mil.wp.help.connection.authentication.data.EmptyRequest;
import pl.mil.wp.help.connection.authentication.data.LoginAuthData;
import pl.mil.wp.help.firebase.interceptors.FCMInterceptor;
import pl.mil.wp.help.firebase.presenter.FirebasePresenter;
import pl.mil.wp.help.shared_preferences.SharedPreferencesUtil;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Sebastian Paciorek
 */
public class RegisterManager implements RegisterInterface {

    private static final String TAG = RegisterManager.class.getSimpleName();

    public static RegisterManager registerManager;

    private Activity activity;

    public static RegisterManager getInstance() {
        if (registerManager == null) {
            synchronized (RegisterManager.class) {
                if (registerManager == null) {
                    registerManager = new RegisterManager();
                }
            }
        }
        return registerManager;
    }

    public RegisterManager() {
    }

    @Override
    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void registerAnonymously() {
        AuthService authService = RetrofitManager.buildService(AuthService.class);
        ApiUsersService apiUsersService = RetrofitManager.buildService(ApiUsersService.class);
        authService.registerAnonymously(EmptyRequest.INSTANCE).enqueue(new Callback<RegisterAnonymousAuthResponse>() {
            @Override
            public void onResponse(Call<RegisterAnonymousAuthResponse> call, Response<RegisterAnonymousAuthResponse> response) {
                if (response.body() != null) {

                    FirebaseInstanceId.getInstance().getInstanceId()
                            .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                                @Override
                                public void onComplete(@NonNull Task<InstanceIdResult> task) {
                                    if (!task.isSuccessful()) {

                                        return;
                                    }
                                    FCMInterceptor.getInstance().setToken(Objects.requireNonNull(task.getResult()).getToken());
                                    Log.d(TAG, "Firebase TOKEN in registerAnonymously: " + FirebasePresenter.getInstance().getToken());

                                    RegisterAnonymousAuthResponse.RegisterAnonymousAuthResponseContent content = response.body().getContent();
                                    LoginAuthData loginAuthData = new LoginAuthData();
                                    loginAuthData.setUid(content.getUid());
                                    loginAuthData.setEmail(content.getEmail());
                                    loginAuthData.setFcmToken(FirebasePresenter.getInstance().getToken());
                                    loginAuthData.setPassword(content.getPassword());
                                    authService.login(loginAuthData).enqueue(new Callback<AuthResponse>() {
                                        @Override
                                        public void onResponse(Call<AuthResponse> call, Response<AuthResponse> response) {
                                            if (response.body() != null) {
                                                setAuthTokenSharedPreferences(response.body().getContent());
                                                setUIDSharedPreferences(loginAuthData.getUid());
                                                setFirebaseCloudMessagingTokenSharedPreferences(loginAuthData.getFcmToken());

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
                                                            Toast.makeText(activity, activity. getString(R.string.login_success_info), Toast.LENGTH_SHORT).show();
                                                            goToMainActivity();
                                                        } else {
                                                            Toast.makeText(activity, activity. getString(R.string.login_auth_problem_info), Toast.LENGTH_SHORT).show();
                                                        }

                                                    }

                                                    @Override
                                                    public void onFailure(Call<AppUserViewModelApiResponse> call, Throwable t) {
                                                        Toast.makeText(activity, activity. getString(R.string.login_failure_info), Toast.LENGTH_SHORT).show();
                                                    }
                                                });

                                            } else {
                                                Toast.makeText(activity, activity. getString(R.string.login_invalid_credentials_info), Toast.LENGTH_SHORT).show();
                                            }
                                        }

                                        @Override
                                        public void onFailure(Call<AuthResponse> call, Throwable t) {
                                            Toast.makeText(activity, activity. getString(R.string.login_failure_info), Toast.LENGTH_SHORT).show();
                                        }
                                    });


                                }
                            });
                } else {
                    Log.d(TAG, response.raw().toString());
                    Toast.makeText(activity, activity.getString(R.string.register_failure_info), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<RegisterAnonymousAuthResponse> call, Throwable t) {
                Log.e(TAG, activity.getString(R.string.register_failure_info), t);
                Toast.makeText(activity, activity.getString(R.string.register_failure_info), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setAuthTokenSharedPreferences(String idToken) {
        SharedPreferencesUtil.setAuthToken(activity, idToken);
    }

    private void setUIDSharedPreferences(String uid) {
        SharedPreferencesUtil.setUID(activity, uid);
    }

    private void setIDUserSharedPreferences(String idUser) {
        SharedPreferencesUtil.setIDUser(activity, idUser);
    }

    private void setFirebaseCloudMessagingTokenSharedPreferences(String fcmToken) {
        SharedPreferencesUtil.setFirebaseCloudMessagingToken(activity, fcmToken);
    }

    private void goToMainActivity() {
        Intent intent = new Intent(activity, MainActivity.class);
        activity.startActivity(intent);
        activity.finish();
    }
}
