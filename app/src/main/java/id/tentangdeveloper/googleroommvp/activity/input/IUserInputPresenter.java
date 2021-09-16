package id.tentangdeveloper.googleroommvp.activity.input;

public interface IUserInputPresenter {
    void formValidation(String name,String email,String address);
    interface IInputUserView {
        void populateForm();
        void showErrorName(String message);
        void showErrorEmail(String message);
        void showErrorAddress(String message);
        void removeError();
        void showToast(String message);
        void clearForm();
    }
}
