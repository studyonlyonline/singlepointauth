package com.authentication.service.common.convertors;

import com.authentication.beans.constants.UserTypeEnum;
import com.authentication.db.entity.UserEntity;
import com.authentication.beans.requestVO.UserRegistrationVO;
import org.springframework.stereotype.Component;

@Component
public class UserRegistrationConvertor {

    public UserEntity convertUserRegistrationVOToEntity(UserRegistrationVO userRegistrationVO){
        return UserEntity.builder()
                .organizationId(userRegistrationVO.getOrganizationId())
                .email(userRegistrationVO.getEmail())
                .password(userRegistrationVO.getPassword())
                .userType(UserTypeEnum.NORMAL)
                .isAccountDeleted(false)
                .build();
    }

}
