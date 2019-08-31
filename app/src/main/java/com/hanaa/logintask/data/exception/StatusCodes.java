package com.hanaa.logintask.data.exception;

public enum StatusCodes {
    LOGIN_SUCESS(1);
    private int status;
    StatusCodes(int status) {
        this.status=status;
    }

    public int getStatus() {
        return status;
    }
}
