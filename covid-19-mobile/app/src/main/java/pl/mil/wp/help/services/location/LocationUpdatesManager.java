package pl.mil.wp.help.services.location;

import android.Manifest;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import androidx.core.app.ActivityCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import pl.mil.wp.help.R;

public class LocationUpdatesManager implements LocationUpdatesManagerInterface {

    private Context context;

    private Activity activity;

    private static final String TAG = LocationUpdatesManager.class.getSimpleName();

    private static final int REQUEST_PERMISSIONS_REQUEST_CODE = 34;

    private LocationUpdatesService locationService = null;

    private boolean bound = false;

    private LocationReceiver locationReceiver;

    private ServiceConnection serviceConnection;

    public LocationUpdatesManager() {
    }

    @Override
    public void startServiceConnection() {

        setLocationReceiver(new LocationReceiver());

        checkCurrentPermissions();

        serviceConnection = new ServiceConnection() {

            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                LocationUpdatesService.LocalBinder binder = (LocationUpdatesService.LocalBinder) service;
                locationService = binder.getService();
                setBound(true);

                tryRequestLocationUpdates();
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                locationService = null;
                setBound(false);
            }
        };
    }

    private void checkCurrentPermissions() {
        if (Utils.requestingLocationUpdates(context)) {
            if (!checkPermissions()) {
                requestPermissions();
            }
        }
    }

    @Override
    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void tryRequestLocationUpdates() {
        if (!checkPermissions()) {
            requestPermissions();
        } else {
            requestLocationUpdates();
        }
    }

    private void requestPermissions() {
        boolean shouldProvideRationale =
                ActivityCompat.shouldShowRequestPermissionRationale(activity,
                        Manifest.permission.ACCESS_FINE_LOCATION);

        // Provide an additional rationale to the user. This would happen if the user denied the
        // request previously, but didn't check the "Don't ask again" checkbox.
        if (shouldProvideRationale) {
            Log.i(TAG, "Displaying permission rationale to provide additional context.");
            Snackbar.make(
                    activity.findViewById(R.id.container),
                    R.string.permission_rationale,
                    Snackbar.LENGTH_INDEFINITE)
                    .setAction(R.string.ok, new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            // Request permission
                            ActivityCompat.requestPermissions(activity,
                                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                                    REQUEST_PERMISSIONS_REQUEST_CODE);
                        }
                    })
                    .show();
        } else {
            Log.i(TAG, "Requesting permission");
            // Request permission. It's possible this can be auto answered if device policy
            // sets the permission in a given state or the user denied the permission
            // previously and checked "Never ask again".
            ActivityCompat.requestPermissions(activity,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    REQUEST_PERMISSIONS_REQUEST_CODE);
        }
    }

    private void requestLocationUpdates() {
        locationService.requestLocationUpdates();
    }

    private boolean checkPermissions() {
        return PackageManager.PERMISSION_GRANTED == ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION);
    }

    @Override
    public void bindConnectionService() {
        context.bindService(new Intent(context, LocationUpdatesService.class), serviceConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    public void unbindConnectionService() {
        if (isBound()) {
            context.unbindService(serviceConnection);
            setBound(false);
        }
    }


    private class LocationReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            Location location = intent.getParcelableExtra(LocationUpdatesService.EXTRA_LOCATION);
//            if (location != null) {
//                Toast.makeText(context, Utils.getLocationText(location),
//                        Toast.LENGTH_SHORT).show();
//            }
        }
    }

    @Override
    public void registerLocationReceiver() {
        LocalBroadcastManager.getInstance(context).registerReceiver(locationReceiver, new IntentFilter(LocationUpdatesService.ACTION_BROADCAST));
    }

    @Override
    public void unregisterLocationReceiver() {
        LocalBroadcastManager.getInstance(context).unregisterReceiver(locationReceiver);
    }

    private boolean isBound() {
        return bound;
    }

    private void setBound(boolean bound) {
        this.bound = bound;
    }

    private void setLocationReceiver(LocationReceiver locationReceiver) {
        this.locationReceiver = locationReceiver;
    }

}
