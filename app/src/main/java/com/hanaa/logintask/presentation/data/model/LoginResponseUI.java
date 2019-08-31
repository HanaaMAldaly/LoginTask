package com.hanaa.logintask.presentation.data.model;

import java.util.List;

public class LoginResponseUI {
    private Integer status;
    private String message;
    private DataUI data;
    private List<Object> extra = null;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataUI getData() {
        return data;
    }

    public void setData(DataUI data) {
        this.data = data;
    }

    public List<Object> getExtra() {
        return extra;
    }

    public void setExtra(List<Object> extra) {
        this.extra = extra;
    }
}
