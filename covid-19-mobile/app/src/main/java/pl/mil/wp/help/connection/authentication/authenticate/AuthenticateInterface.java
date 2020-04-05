package pl.mil.wp.help.connection.authentication.authenticate;

import android.app.Activity;

/**
 * Created by Sebastian Paciorek
 */
public interface AuthenticateInterface {

    boolean userSignedIn();

    boolean userGoogleSignedIn();

    void setActivity(Activity activity);
}
