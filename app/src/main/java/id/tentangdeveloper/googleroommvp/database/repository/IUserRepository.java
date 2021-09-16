package id.tentangdeveloper.googleroommvp.database.repository;

import java.util.List;

import id.tentangdeveloper.googleroommvp.database.entity.User;

public interface IUserRepository {
    void insert(User user);
    void update(User user);
    List<User> find(String keyword);
    void delete(User user);
    User findByEmail(String email);
    User findById(int id);
}
