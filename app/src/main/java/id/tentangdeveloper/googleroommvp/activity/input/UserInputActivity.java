package id.tentangdeveloper.googleroommvp.activity.input;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import id.tentangdeveloper.googleroommvp.databinding.ActivityUserInputBinding;


public class UserInputActivity extends AppCompatActivity implements IUserInputPresenter.IInputUserView {
    private ActivityUserInputBinding binding;
    private UserInputPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserInputBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        presenter = new UserInputPresenter(this,this);

        binding.buttonSave.setOnClickListener(v -> populateForm());
    }

    @Override
    public void populateForm() {
        String name = binding.textName.getEditText().getText().toString();  // populate form , karena menggunakan material TextInputLayout jd harus menggunakan 'getEditText()'
        String email = binding.textEmail.getEditText().getText().toString();
        String address = binding.textAddress.getEditText().getText().toString();

        presenter.formValidation(name,email,address); // melakukan validasi form
    }

    @Override
    public void showErrorName(String message) {
        binding.textName.setError(message); // menampilkan error nama
    }

    @Override
    public void showErrorEmail(String message) {
        binding.textEmail.setError(message); // menampilkan error email
    }

    @Override
    public void showErrorAddress(String message) {
        binding.textAddress.setError(message); // menampilkan error alamat
    }

    @Override
    public void removeError() {
        // menghapus semua error field
        binding.textName.setError("");
        binding.textEmail.setError("");
        binding.textAddress.setError("");
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show(); // menapilkan toast notifikasi
    }

    @Override
    public void clearForm() {
        // menghapus semua isian field
        binding.textName.getEditText().setText("");
        binding.textEmail.getEditText().setText("");
        binding.textAddress.getEditText().setText("");

        removeError();
    }
}