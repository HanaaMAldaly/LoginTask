package com.hanaa.logintask.domain.data.mapper;

import com.hanaa.logintask.data.model.UserCloud;
import com.hanaa.logintask.domain.data.model.UserEntity;

public class UserEntityMapper {
    public static UserEntity map(UserCloud userCloud) {
        UserEntity userEntity = new UserEntity();
        userEntity.setCityId(userCloud.getCityId());
        userEntity.setConfirmCode(userCloud.getConfirmCode());
        userEntity.setCreatedAt(userCloud.getCreatedAt());
        userEntity.setEmailVerifiedAt(userCloud.getEmailVerifiedAt());
        userEntity.setExtraMobile(userCloud.getExtraMobile());
        userEntity.setFollowing(userCloud.getFollowing());
        userEntity.setIsAccepted(userCloud.getIsAccepted());
        userEntity.setIsActive(userCloud.getIsActive());
        userEntity.setIsConfirmed(userCloud.getIsConfirmed());
        userEntity.setIsVerified(userCloud.getIsVerified());
        userEntity.setLang(userCloud.getLang());
        userEntity.setMyFollowers(userCloud.getMyFollowers());
        userEntity.setPriceId(userCloud.getPriceId());
        userEntity.setProff(userCloud.getProff());
        userEntity.setRecover(userCloud.getRecover());
        userEntity.setRole(userCloud.getRole());
        userEntity.setRoleId(userCloud.getRoleId());
        userEntity.setSubProff(userCloud.getSubProff());
        userEntity.setUpdatedAt(userCloud.getUpdatedAt());
        userEntity.setUploadId(userCloud.getUploadId());
        userEntity.setUserBio(userCloud.getUserBio());
        userEntity.setUserCredit(userCloud.getUserCredit());
        userEntity.setConfirmCode(userCloud.getConfirmCode());
        userEntity.setUserEmail(userCloud.getUserEmail());
        userEntity.setUserFirstname(userCloud.getUserFirstname());
        userEntity.setUserHeader(userCloud.getUserHeader());
        userEntity.setUserRateCount(userCloud.getUserRateCount());
        userEntity.setUserMobile(userCloud.getUserMobile());
        userEntity.setUserLng(userCloud.getUserLng());
        userEntity.setUserLat(userCloud.getUserLat());
        userEntity.setUserLastname(userCloud.getUserLastname());
        userEntity.setUserImg(userCloud.getUserImg());
        userEntity.setUserId(userCloud.getUserId());
        userEntity.setUserRate(userCloud.getUserRate());

        return userEntity;
    }
}
