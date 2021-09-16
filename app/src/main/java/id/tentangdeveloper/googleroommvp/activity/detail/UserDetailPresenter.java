package id.tentangdeveloper.googleroommvp.activity.detail;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;

import id.tentangdeveloper.googleroommvp.database.AppDatabase;
import id.tentangdeveloper.googleroommvp.database.entity.User;
import id.tentangdeveloper.googleroommvp.database.repository.UserRepository;

public class UserDetailPresenter implements IUserDetailPresenter {
    private IUserDetailView iUserDetailView;
    private Activity activity;
    private UserRepository userRepository;
    public UserDetailPresenter(Activity activity,IUserDetailView iUserDetailView){
        this.activity = activity;
        this.iUserDetailView = iUserDetailView;
        this.userRepository = new UserRepository(AppDatabase.getInstance(activity));
    }

    @Override
    public void populateExtra(Intent intent) {
        int userId = intent.getIntExtra("UserId",0);
            AsyncTask.execute(() -> {
                User user = userRepository.findById(userId);
                if(user != null)
                    iUserDetailView.manageForm(user);
                else
                    iUserDetailView.onEmptyData();
            });
    }
}
