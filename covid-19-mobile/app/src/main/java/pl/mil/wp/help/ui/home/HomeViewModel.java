package pl.mil.wp.help.ui.home;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import pl.mil.wp.help.room.AppDatabase;
import pl.mil.wp.help.room.entities.location.Location;
import pl.mil.wp.help.room.entities.location.LocationDAO;

public class HomeViewModel extends ViewModel {

    private LocationDAO locationDAO;
    private LiveData<Location> newestLocationByMaxId;
    private LiveData<List<Location>> locationsLiveData;

    private MutableLiveData<String> mText;

    public HomeViewModel() {
        locationDAO = AppDatabase.getDatabase().locationDAO();
        locationsLiveData = locationDAO.getAllLocationsLiveData();
        newestLocationByMaxId = locationDAO.getNewestLocationByMaxId();

        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }

    public LiveData<List<Location>> getAllLocations() {
        return locationsLiveData;
    }

    public LiveData<Location> getNewestLocationByMaxId() {
        return newestLocationByMaxId;
    }
}