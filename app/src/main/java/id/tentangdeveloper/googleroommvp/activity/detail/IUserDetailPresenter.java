package id.tentangdeveloper.googleroommvp.activity.detail;

import android.content.Intent;

import id.tentangdeveloper.googleroommvp.database.entity.User;

public interface IUserDetailPresenter {
    void populateExtra(Intent intent);
    interface IUserDetailView {
        void manageForm(User user);
        void onEmptyData();
    }
}
