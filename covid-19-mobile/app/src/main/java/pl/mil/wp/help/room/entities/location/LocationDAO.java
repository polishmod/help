package pl.mil.wp.help.room.entities.location;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import pl.mil.wp.help.room.entities.location.Location;

/**
 * Created by Sebastian Paciorek
 */
@Dao
public interface LocationDAO {

    @Query("SELECT * FROM location")
    List<Location> getAllLocations();

    @Query("SELECT * FROM location WHERE id IN (:locationIds)")
    List<Location> loadAllByIds(int[] locationIds);

    @Query("SELECT * FROM location WHERE latitude LIKE :latitude AND " +
            "longitude LIKE :longitude LIMIT 1")
    Location findByLatLng(double latitude, double longitude);

    @Query("SELECT * FROM location WHERE id = (SELECT MAX(id) FROM location)")
    LiveData<Location> getNewestLocationByMaxId();

    //TODO Dodać limit dni

    //TODO DODAĆ DNI
    @Query("Select * from location where synchronized = 0 LIMIT :limit")
    List<Location> loadNotSynchronizedWithinPeriod(int limit);

    @Update
    void updateLocation(Location location);

    @Insert
    void insertLocations(Location... locations);

    @Update
    void updateLocations(Location... locations);

    @Delete
    void deleteLocation(Location location);

    @Query("DELETE FROM location")
    void deleteAll();

    @Query("SELECT * FROM location")
    LiveData<List<Location>> getAllLocationsLiveData();
}
