package com.hanaa.logintask.presentation.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.hanaa.logintask.R;
import com.hanaa.logintask.data.exception.StatusCodes;
import com.hanaa.logintask.presentation.util.LoginValidationEnum;
import com.hanaa.logintask.presentation.data.model.LoginResponseUI;
import com.hanaa.logintask.presentation.navigation.NavigationManagement;
import com.hanaa.logintask.presentation.viewmodel.LoginViewModel;
import com.jakewharton.rxbinding3.view.RxView;
import com.jakewharton.rxbinding3.widget.RxTextView;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.login_btn)
    Button loginButton;
    @BindView(R.id.login_progressbar)
    ProgressBar progressBar;
    @BindView(R.id.login_email_text_input_layout)
    TextInputLayout emailTextInputLayout;
    @BindView(R.id.login_password_text_input_layout)
    TextInputLayout passwordTextInputLayout;
    @BindView(R.id.login_email_edit_text)
    TextInputEditText emailEditText;
    @BindView(R.id.login_password_edit_text)
    TextInputEditText passwordEditText;

    @BindView(R.id.register)
    TextView register;
    private LoginViewModel viewModel;
    private CompositeDisposable disposableBag;

    public static Intent getStartIntent(Context context) {
        return new Intent(context, LoginActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        disposableBag = new CompositeDisposable();
        viewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
        register.setText(Html.fromHtml(getString(R.string.dont_have_account)));
        bindEmailValidation();
        bindpasswordValidation();
        bindProgressbar();
        bindLoginBtn();
        bindLoginStatus();
        bindEmailEditText();
        bindPasswordEditText();
    }

    private void bindProgressbar() {
        disposableBag.add(viewModel.getLoadingChannel()
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::changeProgressBarVisibility));
    }

    private void changeProgressBarVisibility(boolean status) {
        progressBar.setVisibility(status ? View.VISIBLE : View.GONE);
    }

    private void bindEmailValidation() {
        disposableBag.add(viewModel.getEmailValidationChannel()
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(this::changeValidation));
    }

    private void bindpasswordValidation() {
        disposableBag.add(viewModel.getPasswordValidationChannel()
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(this::changeValidation));
    }

    private void changeValidation(LoginValidationEnum status) {
        switch (status) {
            case INVALID_EMAIL:
                emailTextInputLayout.setError(getString(R.string.invalid_email));
                break;
            case EMPTY_EMAIL:
                emailTextInputLayout.setError(getString(R.string.empty_email));
                break;
            case EMPTY_PASSWORD:
                passwordTextInputLayout.setError(getString(R.string.empty_password));
                break;
            case VALID_PASSWORD:
                passwordTextInputLayout.setError(null);
                break;
            case VALID_EMAIL:
                emailTextInputLayout.setError(null);
        }

    }

    private void bindLoginBtn() {
        //disposableBag.add()
        disposableBag.add(Observable.combineLatest(viewModel.getEmailValidationChannel(),
                viewModel.getPasswordValidationChannel(), (state1, state2) ->
                        state1 == LoginValidationEnum.VALID_EMAIL && state2 == LoginValidationEnum.VALID_PASSWORD
        )
                .subscribe(it -> {
                    loginButton.setEnabled(it);
                }));
        RxView.clicks(loginButton)
                .observeOn(Schedulers.computation())
                .subscribe((it) -> viewModel.login(emailEditText.getText().toString(),
                        passwordEditText.getText().toString()));

    }

    private void bindLoginStatus() {
        disposableBag.add(viewModel.getLoginResponse()

                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::login));
    }

    private void login(LoginResponseUI loginResponseUI) {
        if (loginResponseUI.getStatus() == StatusCodes.LOGIN_SUCESS.getStatus()) {
            Snackbar.make(passwordEditText, loginResponseUI.getMessage(), 1000)
                    .show();
            new Handler().postDelayed(() -> {
                goToHome(loginResponseUI);
            }, 1000);
        } else {
            Snackbar.make(passwordEditText, loginResponseUI.getMessage(), 1000)
                    .setActionTextColor(getResources().getColor(android.R.color.holo_red_light))
                    .show();
        }
    }

    private void goToHome(LoginResponseUI loginResponseUI) {
        String name = "";
        if (loginResponseUI != null && loginResponseUI.getData() != null &&
                loginResponseUI.getData().getUser() != null && loginResponseUI.getData().getUser().getUserFirstname() != null)
            name = loginResponseUI.getData().getUser().getUserFirstname();
        if (loginResponseUI != null && loginResponseUI.getData() != null &&
                loginResponseUI.getData().getUser() != null && loginResponseUI.getData().getUser().getUserLastname() != null)
            name += " " + loginResponseUI.getData().getUser().getUserLastname();
        NavigationManagement.Navigator.goToMAinActivity(this, name);
        finish();
    }

    private void bindEmailEditText() {
        disposableBag.add(
                RxTextView.textChanges(emailEditText)
                        .debounce(100, TimeUnit.MILLISECONDS)
                        .skip(1)
                        .map(it -> it.toString())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe((it) -> viewModel.validateEmail(it))
        );
    }

    private void bindPasswordEditText() {
        disposableBag.add(
                RxTextView.textChanges(passwordEditText)
                        .debounce(100, TimeUnit.MILLISECONDS)
                        .skip(1)
                        .map(it -> it.toString())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe((it) -> viewModel.validatePassword(it))
        );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        disposableBag.dispose();
    }
}
