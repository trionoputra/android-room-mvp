package id.tentangdeveloper.googleroommvp.activity.list;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;

import java.util.List;

import id.tentangdeveloper.googleroommvp.activity.list.adapter.UserListAdapter;
import id.tentangdeveloper.googleroommvp.database.AppDatabase;
import id.tentangdeveloper.googleroommvp.database.entity.User;
import id.tentangdeveloper.googleroommvp.database.repository.UserRepository;

public class UserListPresenter implements IUserListPresenter{
    private UserRepository userRepository;
    private UserListAdapter adapter;
    private Activity activity;
    private String keyword;
    private IUserListView iUserListView;
    public UserListPresenter(Activity activity,IUserListView iUserListView){
        this.activity = activity;
        this.iUserListView = iUserListView;
        this.userRepository = new UserRepository(AppDatabase.getInstance(activity));
        this.adapter = new UserListAdapter(activity);
        this.keyword = "";

        this.iUserListView.manageListAdapter(adapter);
    }

    @Override
    public void populateUserList() {
        AsyncTask.execute(() -> {
           List<User> userList =  userRepository.find(keyword);
           activity.runOnUiThread(() -> {
                adapter.setData(userList);
           });
        });
    }

    @Override
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
