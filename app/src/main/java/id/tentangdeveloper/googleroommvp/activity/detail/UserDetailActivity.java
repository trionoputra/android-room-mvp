package id.tentangdeveloper.googleroommvp.activity.detail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import id.tentangdeveloper.googleroommvp.R;
import id.tentangdeveloper.googleroommvp.database.entity.User;
import id.tentangdeveloper.googleroommvp.databinding.ActivityUserDetailBinding;

public class UserDetailActivity extends AppCompatActivity implements IUserDetailPresenter.IUserDetailView {
    private ActivityUserDetailBinding binding;
    private UserDetailPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        presenter = new UserDetailPresenter(this,this);
        presenter.populateExtra(getIntent());
    }

    @Override
    public void manageForm(User user) {
        binding.textEmail.setText(user.email);
        binding.textName.setText(user.name);
        binding.textAddress.setText(user.address);
    }

    @Override
    public void onEmptyData() {
        Toast.makeText(this, R.string.data_not_found,Toast.LENGTH_LONG).show();
        finish();
    }
}