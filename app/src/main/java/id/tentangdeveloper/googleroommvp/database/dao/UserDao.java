package id.tentangdeveloper.googleroommvp.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
import id.tentangdeveloper.googleroommvp.database.entity.User;

@Dao
public interface UserDao {
    @Query("SELECT * FROM user")
    List<User> getAll();

    @Query("SELECT * FROM USER WHERE NAME LIKE :keyword OR EMAIL LIKE :keyword ")
    List<User> find(String keyword);

    @Query("SELECT * FROM USER WHERE EMAIL = :email LIMIT 1")
    User findByEmail(String email);

    @Query("SELECT * FROM USER WHERE ID = :id LIMIT 1")
    User findById(int id);

    @Insert
    void insert(User user);

    @Update
    void update(User user);

    @Delete
    void delete(User user);
}
