package id.tentangdeveloper.googleroommvp.database.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "USER")
public class User {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "NAME")
    public String name;

    @ColumnInfo(name = "EMAIL")
    public String email;

    @ColumnInfo(name = "ADDRESS")
    public String address;
}