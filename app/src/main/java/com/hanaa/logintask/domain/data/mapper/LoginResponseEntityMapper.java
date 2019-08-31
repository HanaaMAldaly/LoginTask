package com.hanaa.logintask.domain.data.mapper;

import com.hanaa.logintask.data.model.LoginResponseCloud;
import com.hanaa.logintask.domain.data.model.LoginResponseEntity;

public class LoginResponseEntityMapper {
    public static LoginResponseEntity map(LoginResponseCloud loginResponseCloud){
        LoginResponseEntity entity=new LoginResponseEntity();
        if(loginResponseCloud.getData()!=null)
        entity.setData(DataEntityMapper.map(loginResponseCloud.getData()));
        entity.setExtra(loginResponseCloud.getExtra());
        entity.setMessage(loginResponseCloud.getMessage());
        entity.setStatus(loginResponseCloud.getStatus());
        return entity;
    }
}
