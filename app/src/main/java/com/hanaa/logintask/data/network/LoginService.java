package com.hanaa.logintask.data.network;

import com.hanaa.logintask.data.model.LoginResponseCloud;

import io.reactivex.Observable;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface LoginService {
    @POST("LoginUser")
    Observable<LoginResponseCloud> login(
            @Query("login")String email,
            @Query("password")String password
    );
}
