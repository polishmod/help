package pl.mil.wp.help;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import pl.mil.wp.help.features.location.LocationSynchronizationManager;
import pl.mil.wp.help.firebase.NotificationType;
import pl.mil.wp.help.firebase.presenter.FirebasePresenter;
import pl.mil.wp.help.services.location.LocationUpdatesManager;
import pl.mil.wp.help.services.location.LocationUpdatesManagerInterface;
import pl.mil.wp.help.ui.AcceptDoctorDialog;

import static pl.mil.wp.help.firebase.NotificationType.DATA_PERMISSION;
import static pl.mil.wp.help.firebase.NotificationType.FILL_QUESTIONNAIRE;
import static pl.mil.wp.help.firebase.NotificationType.INFO;
import static pl.mil.wp.help.firebase.NotificationType.MEASURE_TEMPERATURE;
import static pl.mil.wp.help.firebase.NotificationType.MET_INFECTED;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    BottomNavigationView navigationView;

    private static final int REQUEST_PERMISSIONS_REQUEST_CODE = 34;

    private LocationUpdatesManagerInterface locationUpdatesManager;
    private static final int AUDIO_PERMISSION_REQUEST_CODE = 4321;

    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        locationUpdatesManager = new LocationUpdatesManager();
        locationUpdatesManager.setContext(this);
        locationUpdatesManager.setActivity(this);

        setContentView(R.layout.activity_main);

        navigationView = findViewById(R.id.nav_view);
        //In order to rightfully resize bottom navigation on fullscreen mode
        navigationView.setOnApplyWindowInsetsListener(null);

        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupWithNavController(navigationView, navController);

        locationUpdatesManager.startServiceConnection();
        getAudioPermission();

        Log.i(TAG, "TOKEN: " + FirebasePresenter.getInstance().getToken());

        checkIntentExtras();
        new LocationSynchronizationManager().startSynchronization(this);
    }

    public BottomNavigationView getNavigationView() {
        return navigationView;
    }

    public void getAudioPermission() {
        String[] permissions = {Manifest.permission.RECORD_AUDIO};
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, permissions, AUDIO_PERMISSION_REQUEST_CODE);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        locationUpdatesManager.bindConnectionService();
    }

    @Override
    protected void onResume() {
        super.onResume();

        locationUpdatesManager.registerLocationReceiver();
    }

    @Override
    protected void onPause() {
        locationUpdatesManager.unregisterLocationReceiver();
        super.onPause();
    }

    @Override
    protected void onStop() {
        locationUpdatesManager.unbindConnectionService();
        super.onStop();
    }

    private void checkIntentExtras() {

        checkNotificationForeground();

        checkNotificationBackground();

    }

    private void checkNotificationBackground() {
        if (getIntent().getExtras() != null) {
            Log.i(TAG, "getIntent().getExtras() != null");
            for (Object key : getIntent().getExtras().keySet()) {

                Object value = getIntent().getExtras().get((String) key);
                Log.d(TAG, "Key: " + key + " Value: " + value);

                if (key.equals(getString(R.string.notification_extra_background))) {
                    checkNotificationType(value);
                }
            }
        }
    }

    private void checkNotificationType(Object notificationType) {
        if (notificationType != null) {
            if (FILL_QUESTIONNAIRE.getNotificationType().equals(notificationType)) {
                Log.i(TAG, "checkNotificationBackground " + FILL_QUESTIONNAIRE.getNotificationType());
                navigateToQuestionnaireFragment();
            } else if (MET_INFECTED.getNotificationType().equals(notificationType)) {
                Log.i(TAG, "checkNotificationBackground " + MET_INFECTED.getNotificationType());
                navigateToHomeFragment();
            } else if (MEASURE_TEMPERATURE.getNotificationType().equals(notificationType)) {
                Log.i(TAG, "checkNotificationBackground " + MEASURE_TEMPERATURE.getNotificationType());
                navigateToTemperatureFragment();
            } else if (DATA_PERMISSION.getNotificationType().equals(notificationType)) {
                Log.i(TAG, "checkNotificationBackground " + DATA_PERMISSION.getNotificationType());
                navigateToAcceptDoctorDialog();
            } else {
                Log.i(TAG, "checkNotificationBackground " + INFO.getNotificationType());
                navigateToNotificationFragment();
            }
        }
    }

    private void checkNotificationForeground() {
        if (getIntent() != null) {
            NotificationType notificationType = (NotificationType) getIntent().getSerializableExtra((getString(R.string.notification_extra_foreground)));
            if (notificationType != null) {
                switch (notificationType) {
                    case FILL_QUESTIONNAIRE:
                        Log.i(TAG, "checkNotificationForeground " + FILL_QUESTIONNAIRE.getNotificationType());
                        navigateToQuestionnaireFragment();
                        break;
                    case MET_INFECTED:
                        Log.i(TAG, "checkNotificationForeground " + MET_INFECTED.getNotificationType());
                        navigateToHomeFragment();
                        break;
                    case MEASURE_TEMPERATURE:
                        Log.i(TAG, "checkNotificationForeground " + MEASURE_TEMPERATURE.getNotificationType());
                        navigateToTemperatureFragment();
                        break;

                    case DATA_PERMISSION:
                        Log.i(TAG, "checkNotificationForeground " + DATA_PERMISSION.getNotificationType());
                        navigateToAcceptDoctorDialog();
                    case INFO:

                    default:
                        Log.i(TAG, "checkNotificationForeground " + INFO.getNotificationType());
                        navigateToNotificationFragment();
                }
            }
        }
    }

    private void navigateToNotificationFragment() {
        navController.navigate(R.id.navigation_notifications);
    }


    private void navigateToHomeFragment() {
        String metInfectedLocation = getIntent().getStringExtra(getString(R.string.met_infected_location_extra));
        Log.d(TAG, "MET INFECTED LOCATION EXTRAS: " + metInfectedLocation);

        Bundle bundle = new Bundle();
        bundle.putString(getString(R.string.met_infected_location_extra), metInfectedLocation);

        navController.navigate(R.id.navigation_home, bundle);
    }

    private void navigateToQuestionnaireFragment() {
        navController.navigate(R.id.questionnareFragment);
    }

    private void navigateToTemperatureFragment() {
        navController.navigate(R.id.temperatureFragment2);
    }

    private void navigateToAcceptDoctorDialog() {
        String doctorID = getIntent().getStringExtra(getString(R.string.data_permission_doctor_id_extra));
        String doctorName = getIntent().getStringExtra(getString(R.string.data_permission_doctor_name_extra));
        Log.d(TAG, "DATA PERMISSION EXTRAS doctorID: " + doctorID);
        Log.d(TAG, "DATA PERMISSION EXTRAS doctorName: " + doctorName);

        if (doctorName != null && doctorID != null){
            FragmentManager fragmentManager = getSupportFragmentManager();
            new AcceptDoctorDialog(doctorName, Integer.parseInt(doctorID)).show(fragmentManager, null);
        }
//        Bundle bundle = new Bundle();
//        bundle.putString(getString(R.string.data_permission_doctor_id_extra), doctorID);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        Log.i(TAG, "onRequestPermissionResult");
        if (requestCode == REQUEST_PERMISSIONS_REQUEST_CODE) {
            if (grantResults.length <= 0) {

                Log.i(TAG, "User interaction was cancelled.");
            } else if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                locationUpdatesManager.tryRequestLocationUpdates();
            } else {
                Snackbar.make(
                        findViewById(R.id.container),
                        R.string.permission_denied_explanation,
                        Snackbar.LENGTH_INDEFINITE)
                        .setAction(R.string.settings, new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intent = new Intent();
                                intent.setAction(
                                        Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                                Uri uri = Uri.fromParts("package",
                                        BuildConfig.APPLICATION_ID, null);
                                intent.setData(uri);
                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);
                            }
                        })
                        .show();
            }
        }
    }

}
