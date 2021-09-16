package id.tentangdeveloper.googleroommvp.activity.list;

import id.tentangdeveloper.googleroommvp.activity.list.adapter.UserListAdapter;

public interface IUserListPresenter {
    void populateUserList();
    void setKeyword(String keyword);
    interface IUserListView {
        void manageListAdapter(UserListAdapter adapter);
    }
}
