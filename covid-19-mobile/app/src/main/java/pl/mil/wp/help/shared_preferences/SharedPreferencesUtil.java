package pl.mil.wp.help.shared_preferences;

import android.content.Context;
import android.content.SharedPreferences;

import pl.mil.wp.help.R;

import static androidx.preference.PreferenceManager.getDefaultSharedPreferences;

public class SharedPreferencesUtil {

    public static boolean isEnabled(Context context, String event, boolean defValue) {
        return getDefaultSharedPreferences(context).getBoolean(event, defValue);
    }

    public static void setEnabled(Context context, String event, boolean isEnabled) {
        SharedPreferences.Editor editor = getEditor(context);
        editor.putBoolean(event, isEnabled);
        editor.apply();
    }

    public static int getInteger(Context context, String event, int defValue) {
        return getDefaultSharedPreferences(context).getInt(event, defValue);
    }

    public static void setInteger(Context context, String event, int value) {
        SharedPreferences.Editor editor = getEditor(context);
        editor.putInt(event, value);
        editor.apply();
    }

    public static double getFloat(Context context, String event, float defValue) {
        return getDefaultSharedPreferences(context).getFloat(event, defValue);
    }

    public static void setFloat(Context context, String event, float value) {
        SharedPreferences.Editor editor = getEditor(context);
        editor.putFloat(event, value);
        editor.apply();
    }

    public static double getLong(Context context, String event, long defValue) {
        return getDefaultSharedPreferences(context).getLong(event, defValue);
    }

    public static void setLong(Context context, String event, long value) {
        SharedPreferences.Editor editor = getEditor(context);
        editor.putLong(event, value);
        editor.apply();
    }

    public static void setString(Context context, String event, String value) {
        SharedPreferences.Editor editor = getEditor(context);
        editor.putString(event, value);
        editor.apply();
    }

    public static String getString(Context context, String event, String defValue) {
        return getDefaultSharedPreferences(context).getString(event, defValue);
    }

    public static SharedPreferences.Editor getEditor(Context context) {
        return getDefaultSharedPreferences(context).edit();
    }

    public static String getAuthToken(Context context) {
        return getString(context, context.getResources().getString(R.string.auth_token), "");
    }

    public static void setAuthToken(Context context, String authToken) {
        setString(context, context.getResources().getString(R.string.auth_token), authToken);
    }

    public static String getFirebaseCloudMessagingToken(Context context) {
        return getString(context, context.getResources().getString(R.string.fcm_token), "");
    }

    public static void setFirebaseCloudMessagingToken(Context context, String fcmToken) {
        setString(context, context.getResources().getString(R.string.fcm_token), fcmToken);
    }

    public static String getUID(Context context) {
        return getString(context, context.getResources().getString(R.string.uid), "");
    }

    public static void setUID(Context context, String idUser) {
        setString(context, context.getResources().getString(R.string.uid), idUser);
    }

    public static String getIDUser(Context context) {
        return getString(context, context.getResources().getString(R.string.id_user), "");
    }

    public static void setIDUser(Context context, String idUser) {
        setString(context, context.getResources().getString(R.string.id_user), idUser);
    }

}
