package pl.mil.wp.help.firebase.interceptors;

import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.Objects;

import androidx.annotation.NonNull;
import pl.mil.wp.help.firebase.FirebaseMessagingService;

/**
 * Created by Sebastian Paciorek
 */
public class FCMInterceptor implements Interceptor {

    private static FCMInterceptor INSTANCE;

    private static final String TAG = FCMInterceptor.class.getSimpleName();

    private String token = "";

    private FCMInterceptor() {
        setToken();
    }

    public static FCMInterceptor getInstance() {
        if (INSTANCE == null) {
            synchronized (FCMInterceptor.class){
                if (INSTANCE == null){
                    INSTANCE = new FCMInterceptor();
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();

        Request.Builder requestBuilder = original.newBuilder()
                .header("Authorization:key=", getToken());

        Request request = requestBuilder.build();
        return chain.proceed(request);
    }

    public void setToken(String token) {
        this.token = token;
        Log.i(TAG, "setToken() : " + getToken());
    }

    private void setToken() {
        FirebaseInstanceId.getInstance().getInstanceId()
                .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                    @Override
                    public void onComplete(@NonNull Task<InstanceIdResult> task) {
                        if (!task.isSuccessful()) {

                            return;
                        }
                        setToken(Objects.requireNonNull(task.getResult()).getToken());
                    }
                });
    }

    private String getToken() {
        return token;
    }
}
