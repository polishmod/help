package pl.mil.wp.help.firebase;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.util.Log;

import com.google.firebase.messaging.RemoteMessage;

import java.util.Calendar;
import java.util.Date;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import pl.mil.wp.help.MainActivity;
import pl.mil.wp.help.R;
import pl.mil.wp.help.firebase.interceptors.FCMInterceptor;

import static pl.mil.wp.help.firebase.NotificationType.FILL_QUESTIONNAIRE;

/**
 * Created by Sebastian Paciorek
 */
public class FirebaseMessagingService extends com.google.firebase.messaging.FirebaseMessagingService {

    int NOTIFICATION_ID = 1;

    private static final String TAG = FirebaseMessagingService.class.getSimpleName();

    private String NOTIFICATION_TYPE;
    private String MET_INFECTED_LOCATION;

    @Override
    public void onNewToken(@NonNull String s) {
        super.onNewToken(s);

        Log.i(TAG, "onNewToken() " + s);
        FCMInterceptor.getInstance().setToken(s);

    }

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        Log.d(TAG, "onMessageReceived");

        NOTIFICATION_TYPE = remoteMessage.getData().get("NOTIFICATION_TYPE");
        MET_INFECTED_LOCATION = remoteMessage.getData().get(getString(R.string.met_infected_location_extra));

        if (remoteMessage.getNotification() != null) {
            sendNotification(remoteMessage.getNotification());
        }
    }

    private void sendNotification(RemoteMessage.Notification notification) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        intent = putExtraNotificationType(intent);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0 /* Request code */, intent,
                PendingIntent.FLAG_ONE_SHOT);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        String channelId = getString(R.string.default_notification_channel_id);
        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(this, channelId)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle(notification.getTitle())
                        .setContentText(notification.getBody())
                        .setAutoCancel(true)
                        .setSound(defaultSoundUri)
                        .setWhen(Calendar.getInstance().getTimeInMillis())
                        .addAction(R.mipmap.ic_launcher, "See", pendingIntent)
                        .setContentIntent(pendingIntent);


        // Since android Oreo notification channel is needed.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(channelId,
                    getString(R.string.default_notification_channel_name),
                    NotificationManager.IMPORTANCE_DEFAULT);

            if (notificationManager != null) {
                notificationManager.createNotificationChannel(channel);
            }
        }

        NOTIFICATION_ID = (int) ((new Date().getTime() / 1000L) % Integer.MAX_VALUE);  //to multiply notifications
        if (notificationManager != null) {
            notificationManager.notify(NOTIFICATION_ID, notificationBuilder.build());
        }
    }

    private Intent putExtraNotificationType(Intent intent) {
        if (NotificationType.FILL_QUESTIONNAIRE.getNotificationType().equals(NOTIFICATION_TYPE)) {
            intent.putExtra(getString(R.string.notification_extra_foreground), FILL_QUESTIONNAIRE);
        } else if (NotificationType.MET_INFECTED.getNotificationType().equals(NOTIFICATION_TYPE)) {
            intent.putExtra(getString(R.string.notification_extra_foreground), NotificationType.MET_INFECTED);
            intent.putExtra(getString(R.string.met_infected_location_extra), MET_INFECTED_LOCATION);
        } else if (NotificationType.MEASURE_TEMPERATURE.getNotificationType().equals(NOTIFICATION_TYPE)) {
            intent.putExtra(getString(R.string.notification_extra_foreground), NotificationType.MEASURE_TEMPERATURE);
        } else if (NotificationType.DATA_PERMISSION.getNotificationType().equals(NOTIFICATION_TYPE)) {
            intent.putExtra(getString(R.string.notification_extra_foreground), NotificationType.DATA_PERMISSION);
        } else {
            intent.putExtra(getString(R.string.notification_extra_foreground), NotificationType.INFO);
        }

        return intent;
    }
}