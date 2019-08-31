package com.hanaa.logintask.presentation.data.mapper;

import com.hanaa.logintask.domain.data.model.UserEntity;
import com.hanaa.logintask.presentation.data.model.UserUI;

public class UserUIMapper {
    public static UserUI map(UserEntity userEntity) {
        UserUI userUI = new UserUI();
        userUI.setCityId(userEntity.getCityId());
        userUI.setConfirmCode(userEntity.getConfirmCode());
        userUI.setCreatedAt(userEntity.getCreatedAt());
        userUI.setEmailVerifiedAt(userEntity.getEmailVerifiedAt());
        userUI.setExtraMobile(userEntity.getExtraMobile());
        userUI.setFollowing(userEntity.getFollowing());
        userUI.setIsAccepted(userEntity.getIsAccepted());
        userUI.setIsActive(userEntity.getIsActive());
        userUI.setIsConfirmed(userEntity.getIsConfirmed());
        userUI.setIsVerified(userEntity.getIsVerified());
        userUI.setLang(userEntity.getLang());
        userUI.setMyFollowers(userEntity.getMyFollowers());
        userUI.setPriceId(userEntity.getPriceId());
        userUI.setProff(userEntity.getProff());
        userUI.setRecover(userEntity.getRecover());
        userUI.setRole(userEntity.getRole());
        userUI.setRoleId(userEntity.getRoleId());
        userUI.setSubProff(userEntity.getSubProff());
        userUI.setUpdatedAt(userEntity.getUpdatedAt());
        userUI.setUploadId(userEntity.getUploadId());
        userUI.setUserBio(userEntity.getUserBio());
        userUI.setUserCredit(userEntity.getUserCredit());
        userUI.setConfirmCode(userEntity.getConfirmCode());
        userUI.setUserEmail(userEntity.getUserEmail());
        userUI.setUserFirstname(userEntity.getUserFirstname());
        userUI.setUserHeader(userEntity.getUserHeader());
        userUI.setUserRateCount(userEntity.getUserRateCount());
        userUI.setUserMobile(userEntity.getUserMobile());
        userUI.setUserLng(userEntity.getUserLng());
        userUI.setUserLat(userEntity.getUserLat());
        userUI.setUserLastname(userEntity.getUserLastname());
        userUI.setUserImg(userEntity.getUserImg());
        userUI.setUserId(userEntity.getUserId());
        userUI.setUserRate(userEntity.getUserRate());

        return userUI;
    }
}
