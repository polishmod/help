package pl.mil.wp.help.ui;

import android.app.Activity;
import android.os.Handler;
import android.view.View;

public class Utils {

    public static void enableFullscreen(Activity activity) {
        final int duration = 2000;
        View decorView = activity.getWindow().getDecorView();
        int uiOptions =

                View.SYSTEM_UI_FLAG_IMMERSIVE
                        // Set the content to appear under the system bars so that the
                        // content doesn't resize when the system bars hide and show.
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        // Hide the nav bar and status bar
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN;

        decorView.setSystemUiVisibility(uiOptions);

        decorView.setOnSystemUiVisibilityChangeListener(visibility -> {
            if ((visibility & View.SYSTEM_UI_FLAG_FULLSCREEN) == 0) {
                Handler handler = new Handler();
                handler.postDelayed(() -> {
                    if (decorView.getSystemUiVisibility() != 0) {
                        decorView.setSystemUiVisibility(uiOptions);
                    }
                }, duration);
            }
        });
    }

    public static void disableFullscreen(Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        decorView.setSystemUiVisibility(0);
    }

}
