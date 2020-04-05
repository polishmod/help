package pl.mil.wp.help;

import android.app.Application;

/**
 * Created by Sebastian Paciorek
 */
public class HelpApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        DatabaseProvider.getInstance().initDatabase(this);
    }
}
