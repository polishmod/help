package pl.mil.wp.help.ui.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import pl.mil.wp.help.AuthenticationActivity;
import pl.mil.wp.help.MainActivity;
import pl.mil.wp.help.R;
import pl.mil.wp.help.connection.authentication.authenticate.AuthenticateInterface;
import pl.mil.wp.help.connection.authentication.authenticate.AuthenticateManager;

public class SplashActivity extends AppCompatActivity {

    private static final String TAG = SplashActivity.class.getSimpleName();
    private Handler handler;
    private boolean mShouldFinish = false;

    private AuthenticateInterface authenticateManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        authenticateManager = AuthenticateManager.getInstance();
        authenticateManager.setActivity(this);

        handler = new Handler();
        try {
            handler.postDelayed(this::checkUserAlreadySignedIn, 400);

        } catch (Exception e) {

        }
    }

    @Override
    protected void onPause() {
        handler.removeCallbacksAndMessages(null);
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mShouldFinish) {
            finish();
        }
    }

    @Override
    protected void onDestroy() {
        handler.removeCallbacksAndMessages(null);
        super.onDestroy();
    }

    private void checkUserAlreadySignedIn() {
        if (authenticateManager.userSignedIn() || authenticateManager.userGoogleSignedIn()) {
            goToMainActivity();
        } else {
            goToAuthenticationActivity();
        }
    }

    private void goToMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        if (getIntent().getExtras() != null) {
            intent.putExtras(getIntent().getExtras());
        }
        startActivity(intent);
        finish();
    }

    private void goToAuthenticationActivity() {
        Intent intent = new Intent(this, AuthenticationActivity.class);
        ActivityOptionsCompat options = ActivityOptionsCompat.
                makeSceneTransitionAnimation(this, findViewById(R.id.splashImage), getString(R.string.activity_image_trans));
        startActivity(intent, options.toBundle());
        mShouldFinish = true;
    }
}
