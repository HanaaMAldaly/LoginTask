package com.hanaa.logintask.presentation.data.mapper;

import com.hanaa.logintask.domain.data.model.LoginResponseEntity;
import com.hanaa.logintask.presentation.data.model.LoginResponseUI;

public class LoginResponseUIMapper {
    public static LoginResponseUI map(LoginResponseEntity loginResponseEntity){
        LoginResponseUI loginResponseUI=new LoginResponseUI();
        if(loginResponseEntity.getData()!=null)
        loginResponseUI.setData(DataUIMapper.map(loginResponseEntity.getData()));
        loginResponseUI.setExtra(loginResponseEntity.getExtra());
        loginResponseUI.setMessage(loginResponseEntity.getMessage());
        loginResponseUI.setStatus(loginResponseEntity.getStatus());
        return loginResponseUI;
    }
}
