package com.hanaa.logintask.data.network;

import com.hanaa.logintask.data.model.LoginResponseCloud;

import io.reactivex.Observable;


public class LoginCloudManagement {
    private LoginCloudManagement() {
    }

    private static class CloudInstance {
        private static LoginCloudManagement INSTANCE = new LoginCloudManagement();
    }

    public static LoginCloudManagement getInstance() {
        return CloudInstance.INSTANCE;
    }

    public Observable<LoginResponseCloud> login(String email, String password) {

        return BaseNetwork.getInstance().create(LoginService.class).login(email, password);
    }
}
