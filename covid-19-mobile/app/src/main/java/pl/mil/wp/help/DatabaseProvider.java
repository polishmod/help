package pl.mil.wp.help;

import android.content.Context;

import androidx.room.Room;
import pl.mil.wp.help.room.AppDatabase;

/**
 * Created by Sebastian Paciorek
 */
public class DatabaseProvider {

    public static DatabaseProvider INSTANCE;

    private static final String DB_NAME = "help.db";

    private AppDatabase appDatabase;

    public static DatabaseProvider getInstance() {
        if (INSTANCE == null) {
            synchronized (DatabaseProvider.class){
                if (INSTANCE == null){
                    INSTANCE = new DatabaseProvider();
                }
            }
        }
        return INSTANCE;
    }

    void initDatabase(Context context) {
        appDatabase = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, DB_NAME).build();
    }

    public AppDatabase getAppDatabase() {
        return appDatabase;
    }
}
