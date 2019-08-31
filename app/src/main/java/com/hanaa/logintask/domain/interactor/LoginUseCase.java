package com.hanaa.logintask.domain.interactor;

import com.hanaa.logintask.data.repository.LoginRepositoryImpl;
import com.hanaa.logintask.domain.data.mapper.LoginResponseEntityMapper;
import com.hanaa.logintask.domain.data.model.LoginResponseEntity;

import io.reactivex.Observable;

public class LoginUseCase {
    public Observable<LoginResponseEntity> build(String email, String password){
        return LoginRepositoryImpl.getInstance().login(email,password)
                .map(LoginResponseEntityMapper::map);
    }
}
