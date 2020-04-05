package pl.mil.wp.help.features.location;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import java.io.IOException;
import java.util.List;

import java8.util.stream.Collectors;
import java8.util.stream.StreamSupport;
import pl.mil.wp.help.R;
import pl.mil.wp.help.connection.RetrofitManager;
import pl.mil.wp.help.connection.location.LocationDto;
import pl.mil.wp.help.connection.location.LocationDtoMapper;
import pl.mil.wp.help.connection.location.LocationResponse;
import pl.mil.wp.help.connection.location.LocationService;
import pl.mil.wp.help.connection.questionnary.UploadWorker;
import pl.mil.wp.help.room.AppDatabase;
import pl.mil.wp.help.room.entities.location.Location;
import pl.mil.wp.help.shared_preferences.SharedPreferencesUtil;
import retrofit2.Response;

public class LocationSynchronizationWorker extends Worker {
    private final static String TAG = UploadWorker.class.getSimpleName();
    private String token;
    List<LocationDto> locationDtos;

    public LocationSynchronizationWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
        String event = context.getString(R.string.auth_token);
        this.token = SharedPreferencesUtil.getString(context, event, "");
    }

    @NonNull
    @Override
    public Result doWork() {
        String bearer = "Bearer " + this.token;
        LocationService service = RetrofitManager.buildService(LocationService.class);
        List<Location> notSyncLocations = AppDatabase.getDatabase().locationDAO().loadNotSynchronizedWithinPeriod(500);
        if (notSyncLocations.isEmpty()) return Result.success();
        locationDtos = locationListToDtoList(notSyncLocations);
        try {
            boolean isSynchronized = synchronize(service, bearer, locationDtos);
            if (isSynchronized) {
                synchronizeAndSave(notSyncLocations);
                return Result.success();
            } else {
                return Result.retry();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return Result.retry();
        }
    }

    private boolean synchronize(LocationService service, String bearer, List<LocationDto> dtoList) throws IOException {
        for (int i = 0; i < 10; i++) {
            int end = Math.min(i * 10, dtoList.size());
            List<LocationDto> temp = dtoList.subList(i, end);
            Response<LocationResponse> response = service.sendLocationData(bearer, temp).execute();
            if (!response.isSuccessful()) return false;
            if (end == dtoList.size()) i = 10;
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    private List<LocationDto> locationListToDtoList(List<Location> list) {
        return StreamSupport
                .stream(list)
                .map(LocationDtoMapper::locationToDto)
                .collect(Collectors.toList());
    }

    private void synchronizeAndSave(List<Location> locations) {
        StreamSupport
                .stream(locations)
                .forEach(location -> {
                    location.isSynchronized = true;
                    AppDatabase.getDatabase().locationDAO().updateLocation(location);
                });
    }
}
