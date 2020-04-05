package pl.mil.wp.help.features.location;

import android.content.Context;

import androidx.work.Constraints;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.NetworkType;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;

import java.util.concurrent.TimeUnit;

public class LocationSynchronizationManager {

    private Constraints constraints = new Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build();


    PeriodicWorkRequest uploadRequest =
            new PeriodicWorkRequest.Builder(LocationSynchronizationWorker.class, 15, TimeUnit.MINUTES)
                    //TODO Zmienić na 2 min
                    .setConstraints(constraints)
                    .build();


    public void startSynchronization(Context context) {
        WorkManager.getInstance(context).enqueueUniquePeriodicWork("uploadUnique", ExistingPeriodicWorkPolicy.REPLACE, uploadRequest);
    }


}
