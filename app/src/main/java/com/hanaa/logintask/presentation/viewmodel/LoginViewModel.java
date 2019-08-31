package com.hanaa.logintask.presentation.viewmodel;

import android.arch.lifecycle.ViewModel;

import com.hanaa.logintask.data.exception.LoginFailedException;
import com.hanaa.logintask.domain.data.mapper.LoginResponseEntityMapper;
import com.hanaa.logintask.domain.interactor.LoginUseCase;
import com.hanaa.logintask.presentation.util.LoginValidationEnum;
import com.hanaa.logintask.presentation.data.mapper.LoginResponseUIMapper;
import com.hanaa.logintask.presentation.data.model.LoginResponseUI;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;

public class LoginViewModel extends ViewModel {
    private CompositeDisposable disposableBag;
    private BehaviorSubject<Boolean> loadingChannel;
    private BehaviorSubject<LoginValidationEnum> emailValidationChannel;
    private BehaviorSubject<LoginValidationEnum> passwordValidationChannel;
    private BehaviorSubject<LoginResponseUI> loginResponse;
    private Scheduler scheduler;

    LoginViewModel() {
        disposableBag = new CompositeDisposable();
        loadingChannel = BehaviorSubject.createDefault(false);
        emailValidationChannel = BehaviorSubject.create();
        passwordValidationChannel = BehaviorSubject.create();
        loginResponse = BehaviorSubject.create();
        scheduler = Schedulers.computation();
    }

    public BehaviorSubject<LoginValidationEnum> getEmailValidationChannel() {
        return emailValidationChannel;
    }

    public BehaviorSubject<Boolean> getLoadingChannel() {
        return loadingChannel;
    }

    public BehaviorSubject<LoginValidationEnum> getPasswordValidationChannel() {
        return passwordValidationChannel;
    }

    public BehaviorSubject<LoginResponseUI> getLoginResponse() {
        return loginResponse;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposableBag.dispose();
    }

    public void login(String email, String password) {
        disposableBag.add(
                new LoginUseCase().build(email, password)
                        .doOnSubscribe(it -> loadingChannel.onNext(true))
                        .subscribeOn(scheduler)
                        .observeOn(scheduler)
                        .map(LoginResponseUIMapper::map)
                        .observeOn(AndroidSchedulers.mainThread())
                        .doFinally(() -> loadingChannel.onNext(false))
                        .subscribe(it -> {
                            loginResponse.onNext(it);
                        }, throwable -> {
                            throwable.printStackTrace();
                            if (throwable instanceof LoginFailedException)
                                loginResponse.onNext(LoginResponseUIMapper.map(LoginResponseEntityMapper.map(((LoginFailedException) throwable).getLoginResponse())));
                        })
        );
    }

    public void validateEmail(String email) {
        if (email == null || email.isEmpty())
            emailValidationChannel.onNext(LoginValidationEnum.EMPTY_EMAIL);
        else
            emailValidationChannel.onNext(LoginValidationEnum.VALID_EMAIL);

    }

    public void validatePassword(String password) {
        if (password == null || password.isEmpty())
            passwordValidationChannel.onNext(LoginValidationEnum.EMPTY_PASSWORD);
        else
            passwordValidationChannel.onNext(LoginValidationEnum.VALID_PASSWORD);

    }
}
