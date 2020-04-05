package pl.mil.wp.help.connection.authentication.authenticate;

import android.app.Activity;
import android.util.Log;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

import pl.mil.wp.help.R;
import pl.mil.wp.help.shared_preferences.SharedPreferencesUtil;

import static androidx.constraintlayout.widget.Constraints.TAG;

/**
 * Created by Sebastian Paciorek
 */
public class AuthenticateManager implements AuthenticateInterface {

    public static AuthenticateManager authenticateManager;

    private Activity activity;

    public static AuthenticateManager getInstance() {
        if (authenticateManager == null) {
            synchronized (AuthenticateManager.class) {
                if (authenticateManager == null) {
                    authenticateManager = new AuthenticateManager();
                }
            }
        }
        return authenticateManager;
    }

    public AuthenticateManager() {
    }

    @Override
    public boolean userSignedIn() {
        String authToken = SharedPreferencesUtil.getString(activity, activity.getResources().getString(R.string.auth_token), "exampleToken");

        return !authToken.equals("exampleToken");
    }

    @Override
    public boolean userGoogleSignedIn() {
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(activity);

        if (account != null) {
            Log.d(TAG, "USER IS ALREADY SIGNED IN WITH GOOGLE");
            return true;
        } else {
            Log.d(TAG, "USER IS NOT SIGNED IN WITH GOOGLE");
            return false;
        }

    }

    @Override
    public void setActivity(Activity activity) {
        this.activity = activity;
    }
}
