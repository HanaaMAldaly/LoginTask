package com.hanaa.logintask.presentation.data.mapper;

import com.hanaa.logintask.domain.data.model.CityEntity;
import com.hanaa.logintask.presentation.data.model.CityUI;

public class CityUIMapper {
    public static CityUI map(CityEntity cityEntity){
        CityUI cityUI=new CityUI();
        cityUI.setId(cityEntity.getId());
        cityUI.setName(cityEntity.getName());
        return cityUI;
    }
}
