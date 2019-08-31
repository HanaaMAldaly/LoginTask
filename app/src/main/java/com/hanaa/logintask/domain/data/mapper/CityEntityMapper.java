package com.hanaa.logintask.domain.data.mapper;

import com.hanaa.logintask.data.model.CityCloud;
import com.hanaa.logintask.domain.data.model.CityEntity;

public class CityEntityMapper {
    public static CityEntity map(CityCloud cityCloud){
        CityEntity entity=new CityEntity();
        entity.setId(cityCloud.getId());
        entity.setName(cityCloud.getName());
        return entity;
    }
}
