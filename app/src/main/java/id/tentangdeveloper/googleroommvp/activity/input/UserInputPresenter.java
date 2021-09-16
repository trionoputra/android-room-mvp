package id.tentangdeveloper.googleroommvp.activity.input;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Patterns;

import id.tentangdeveloper.googleroommvp.R;
import id.tentangdeveloper.googleroommvp.database.AppDatabase;
import id.tentangdeveloper.googleroommvp.database.entity.User;
import id.tentangdeveloper.googleroommvp.database.repository.UserRepository;

public class UserInputPresenter implements IUserInputPresenter {
    private IInputUserView iInputUserView;
    private Activity activity;
    private User user;
    private UserRepository userRepository;
    public UserInputPresenter(Activity activity, IInputUserView iInputUserView){
        this.iInputUserView = iInputUserView;
        this.activity = activity;
        this.userRepository = new UserRepository(AppDatabase.getInstance(activity));
    }

    @Override
    public void formValidation(String name, String email, String address) {
        // Menghapus error sebelumnya jika ada
        iInputUserView.removeError();

        boolean valid = true;
        // cek field nama tidak boleh kosong
        if(name.equals("")){
            iInputUserView.showErrorName(activity.getString(R.string.hint_error_empty));
            valid = false;
        }

        // cek field email tidak boleh kosong dan cek format email
        if(email.equals("") ){
            iInputUserView.showErrorEmail(activity.getString(R.string.hint_error_empty));
            valid = false;
        }
        else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            iInputUserView.showErrorEmail(activity.getString(R.string.hint_error_valid_email));
            valid = false;
        }

        // cek field address tidak boleh kosong
        if(address.equals("")){
            iInputUserView.showErrorAddress(activity.getString(R.string.hint_error_empty));
            valid = false;
        }

        if(valid){
            AsyncTask.execute(() -> { // cek ke db apakah email sudah terdaftar dengan AsyncTask agar tidak memblok UI thread
                User user = this.userRepository.findByEmail(email);
                if(user == null){
                    user = new User();
                    user.name = name;
                    user.email = email;
                    user.address = address;
                    save(user); // memangil fungsi simpan
                } else {
                    activity.runOnUiThread(() -> { // Menampikan error duplikasi email dan kembali ke UI Thread
                        iInputUserView.showErrorEmail(activity.getString(R.string.hint_error_duplicate_email));
                    });
                }
            });
        }
    }

    private void save(User user){
        this.userRepository.insert(user); // simpan data user ke database
        activity.runOnUiThread(() -> { // Menampikan notif sukses dan kembali ke UI Thread
            iInputUserView.showToast(activity.getString(R.string.hint_success_save));
            iInputUserView.clearForm();
        });
    }
}
