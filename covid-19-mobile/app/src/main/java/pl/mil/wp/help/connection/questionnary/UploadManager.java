package pl.mil.wp.help.connection.questionnary;


import android.content.Context;

import androidx.work.Constraints;
import androidx.work.ExistingWorkPolicy;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

public class UploadManager {

    private Constraints constraints = new Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build();

    OneTimeWorkRequest dataUploader =
            new OneTimeWorkRequest.Builder(UploadWorker.class)
                    .setConstraints(constraints)
                    .build();

    public void upload(Context context) {
        WorkManager.getInstance(context).enqueueUniqueWork("uploadUnique", ExistingWorkPolicy.REPLACE, dataUploader);
    }


}
