package pl.mil.wp.help.services.location;

import android.app.Activity;
import android.content.Context;

/**
 * Created by Sebastian Paciorek
 */
public interface LocationUpdatesManagerInterface {

    void setContext(Context context);

    void setActivity(Activity activity);

    void tryRequestLocationUpdates();

    void bindConnectionService();

    void unbindConnectionService();

    void startServiceConnection();

    void registerLocationReceiver();

    void unregisterLocationReceiver();
}
