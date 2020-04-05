package pl.mil.wp.help.room.entities.location;

import java.util.Date;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Created by Sebastian Paciorek
 */
@Entity
public class Location {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "latitude")
    public double latitude;

    @ColumnInfo(name = "longitude")
    public double longitude;

    @ColumnInfo(name = "accuracy")
    public float accuracy;

    @ColumnInfo(name = "speed")
    public float speed;

    @ColumnInfo(name = "date")
    public String date = (String) android.text.format.DateFormat.format("yyyy-MM-ddTHH:mm:ss", new Date());

    @ColumnInfo(name = "synchronized")
    public boolean isSynchronized;
}
