package com.hanaa.logintask.domain.repository;

import com.hanaa.logintask.data.model.LoginResponseCloud;

import io.reactivex.Observable;


public interface LoginRepository {
    Observable<LoginResponseCloud> login(String email, String password);
}
