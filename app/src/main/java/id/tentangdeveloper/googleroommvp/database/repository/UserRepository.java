package id.tentangdeveloper.googleroommvp.database.repository;

import java.util.List;

import id.tentangdeveloper.googleroommvp.database.AppDatabase;
import id.tentangdeveloper.googleroommvp.database.dao.UserDao;
import id.tentangdeveloper.googleroommvp.database.entity.User;

public class UserRepository implements IUserRepository{
    private UserDao userDao;
    public UserRepository(AppDatabase appDatabase){
        userDao = appDatabase.userDataDao();
    }

    @Override
    public void insert(User user) {
        userDao.insert(user);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public List<User> find(String keyword) {
        return userDao.find("%" + keyword + "%");
    }

    @Override
    public void delete(User user) {
        userDao.delete(user);
    }

    @Override
    public User findByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    public User findById(int id) {
        return userDao.findById(id);
    }
}
