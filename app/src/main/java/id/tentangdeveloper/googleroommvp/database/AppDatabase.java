package id.tentangdeveloper.googleroommvp.database;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import java.io.IOException;

import id.tentangdeveloper.googleroommvp.database.dao.UserDao;
import id.tentangdeveloper.googleroommvp.database.entity.User;

@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    private static final String dbName = "db_tentangdeveloper";

    private static AppDatabase INSTANCE;

    public abstract UserDao userDataDao();

    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            try {
                INSTANCE = buildDatabase(context);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return INSTANCE;
    }

    private static AppDatabase buildDatabase(final Context context) throws IOException {
        return Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, dbName)
               .allowMainThreadQueries().build();
    }
}
