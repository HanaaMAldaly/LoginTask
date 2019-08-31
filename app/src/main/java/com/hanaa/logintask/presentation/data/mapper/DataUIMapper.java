package com.hanaa.logintask.presentation.data.mapper;

import com.hanaa.logintask.domain.data.model.DataEntity;
import com.hanaa.logintask.presentation.data.model.DataUI;

public class DataUIMapper {
    public static DataUI map(DataEntity dataEntity){
        DataUI dataUI=new DataUI();
        if(dataEntity!=null&&dataEntity.getUser()!=null)
        dataUI.setUser(UserUIMapper.map(dataEntity.getUser()));
        return dataUI;
    }
}
