package com.hanaa.logintask.data.exception;

import com.hanaa.logintask.data.model.LoginResponseCloud;

public class LoginFailedException extends Exception {
    private LoginResponseCloud loginResponse;

    public LoginFailedException(LoginResponseCloud loginResponse) {
        this.loginResponse=loginResponse;
    }

    public void setLoginResponse(LoginResponseCloud loginResponse) {
        this.loginResponse = loginResponse;
    }

    public LoginResponseCloud getLoginResponse() {
        return loginResponse;
    }
}
