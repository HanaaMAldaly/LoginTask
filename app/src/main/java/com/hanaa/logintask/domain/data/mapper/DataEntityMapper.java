package com.hanaa.logintask.domain.data.mapper;

import com.hanaa.logintask.data.model.DataCloud;
import com.hanaa.logintask.domain.data.model.DataEntity;
import com.hanaa.logintask.domain.data.model.UserEntity;

public class DataEntityMapper {
    public static DataEntity map(DataCloud dataCloud){
        DataEntity dataEntity=new DataEntity();
        if(dataCloud!=null&&dataCloud.getUser()!=null)
        dataEntity.setUser(UserEntityMapper.map(dataCloud.getUser()));
        return dataEntity;
    }
}
