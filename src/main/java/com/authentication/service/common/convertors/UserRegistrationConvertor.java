package com.authentication.service.common.convertors;

import com.authentication.db.entity.UserEntity;
import com.authentication.requestVO.UserRegistrationVO;
import org.springframework.stereotype.Component;

@Component
public class UserRegistrationConvertor {

    public UserEntity convertUserRegistrationVOToEntity(UserRegistrationVO userRegistrationVO){
        return UserEntity.builder()
                .origanizationId(userRegistrationVO.getOrganizationId())
                .email(userRegistrationVO.getEmail())
                .password(userRegistrationVO.getPassword())
                .build();
    }

}
