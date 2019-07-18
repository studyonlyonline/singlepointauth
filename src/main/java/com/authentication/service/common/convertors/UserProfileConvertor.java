package com.authentication.service.common.convertors;

import com.authentication.beans.requestVO.UserCreateCorporateProfileVO;
import com.authentication.beans.requestVO.UserCreateProfileInfoVO;
import com.authentication.db.entity.UserCorporateProfileEntity;
import com.authentication.db.entity.UserProfileEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class UserProfileConvertor {

    public UserProfileEntity convertUserCreateProfileInfoVOToEntity(UserCreateProfileInfoVO userCreateProfileInfoVO){
        return UserProfileEntity.builder()
                .userId(userCreateProfileInfoVO.getUserId())
                .email(userCreateProfileInfoVO.getEmailId())
                .organizationId(userCreateProfileInfoVO.getOrganizationId())
                .firstname(userCreateProfileInfoVO.getFirstname())
                .lastname(userCreateProfileInfoVO.getLastname())
                .address(userCreateProfileInfoVO.getAddress())
                .pincode(userCreateProfileInfoVO.getPincode())
                .profileVerified(false)
                .createdOn(LocalDateTime.now())
                .build();
    }

    public UserCorporateProfileEntity convertCreateCorporateProfileVOToEntity(UserCreateCorporateProfileVO userCreateCorporateProfileVO){
        return UserCorporateProfileEntity.builder()
                .userId(userCreateCorporateProfileVO.getUserId())
                .email(userCreateCorporateProfileVO.getEmailId())
                .organizationId(userCreateCorporateProfileVO.getOrganizationId())
                .firmName(userCreateCorporateProfileVO.getFirmName())
                .gstin(userCreateCorporateProfileVO.getGstin())
                .aadharNo(userCreateCorporateProfileVO.getAadharNo())
                .billingAddress(userCreateCorporateProfileVO.getBillingAddress())
                .profileVerified(false)
                .createdOn(LocalDateTime.now())
                .build();
    }

}
