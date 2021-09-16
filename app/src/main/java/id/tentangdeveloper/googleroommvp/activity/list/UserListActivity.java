package id.tentangdeveloper.googleroommvp.activity.list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import id.tentangdeveloper.googleroommvp.activity.input.UserInputActivity;
import id.tentangdeveloper.googleroommvp.activity.list.adapter.UserListAdapter;
import id.tentangdeveloper.googleroommvp.databinding.ActivityUserListBinding;

public class UserListActivity extends AppCompatActivity implements IUserListPresenter.IUserListView {
    private ActivityUserListBinding binding;
    private UserListPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        presenter = new UserListPresenter(this,this);

        binding.floatingActionButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, UserInputActivity.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.populateUserList();
    }

    @Override
    public void manageListAdapter(UserListAdapter adapter) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recyclerView.setLayoutManager(layoutManager);
        binding.recyclerView.setAdapter(adapter);
    }
}