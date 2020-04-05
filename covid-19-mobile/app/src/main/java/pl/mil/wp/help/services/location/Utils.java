package pl.mil.wp.help.services.location;

import android.content.Context;
import android.location.Location;
import android.preference.PreferenceManager;

import java.util.Random;

import pl.mil.wp.help.R;

/**
 * Created by Sebastian Paciorek
 */
public class Utils {

    public static final String KEY_REQUESTING_LOCATION_UPDATES = "requesting_location_updates";

    /**
     * Returns true if requesting location updates, otherwise returns false.
     *
     * @param context The {@link Context}.
     */
    public static boolean requestingLocationUpdates(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context)
                .getBoolean(KEY_REQUESTING_LOCATION_UPDATES, false);
    }

    /**
     * Stores the location updates state in SharedPreferences.
     *
     * @param requestingLocationUpdates The location updates state.
     */
    public static void setRequestingLocationUpdates(Context context, boolean requestingLocationUpdates) {
        PreferenceManager.getDefaultSharedPreferences(context)
                .edit()
                .putBoolean(KEY_REQUESTING_LOCATION_UPDATES, requestingLocationUpdates)
                .apply();
    }

    /**
     * Returns the {@code location} object as a human readable string.
     *
     * @param location The {@link Location}.
     */
    public static String getLocationText(Location location) {
        return location == null ? "Unknown location" :
                "LocationPoint determined";
    }

    public static String getLocationTitle(Context context) {
        return context.getString(R.string.location_updated) + "\n" + getDetectedInfectionsText(context);
    }

    public static String getDetectedInfectionsText(Context context) {
        Random random = new Random();
        int detectedInfections = random.nextInt(6 - 2) + 2;
        return String.format("%d %s", detectedInfections, context.getString(R.string.notification_detected_infections_title)) ;
    }

}
