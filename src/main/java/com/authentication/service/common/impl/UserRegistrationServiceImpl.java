package com.authentication.service.common.impl;

import com.authentication.beans.responseVO.UserCreateProfileResponseVO;
import com.authentication.beans.responseVO.UserRegisterResponseVO;
import com.authentication.beans.responseVO.responseGeneratorUtils.ResponseBuilderUtils;
import com.authentication.db.dao.IUserRepository;
import com.authentication.db.entity.UserCorporateProfileEntity;
import com.authentication.db.entity.UserEntity;
import com.authentication.beans.requestVO.UserRegistrationVO;
import com.authentication.service.common.IUserRegistrationService;
import com.authentication.service.common.convertors.UserRegistrationConvertor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@Service
public class UserRegistrationServiceImpl implements IUserRegistrationService {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private UserRegistrationConvertor userRegistrationConvertor;

    @Override
    public UserRegisterResponseVO registerUserByEmail(UserRegistrationVO userRegistrationVO) {
        try {
            if (userRepository.findByEmailAndOrganizationId(userRegistrationVO.getEmail(), userRegistrationVO.getOrganizationId()).size() > 0) {
                log.error("User Registration failed, user already exists");
                throw new Exception("User already exists");
            }
            UserEntity newUser = userRegistrationConvertor.convertUserRegistrationVOToEntity(userRegistrationVO);
            newUser = userRepository.save(newUser);
            return prepareResponse(newUser, null);
        } catch (Exception ex){
            return prepareResponse(null, ex.getMessage());
        }
    }

    private UserRegisterResponseVO prepareResponse(UserEntity userEntity, String message) {
        if(Objects.isNull(userEntity)){
                return UserRegisterResponseVO.builder()
                        .metaNode(ResponseBuilderUtils.userRegistrationFailed(message))
                        .build();
            }
            return UserRegisterResponseVO.builder()
                    .metaNode(ResponseBuilderUtils.userRegistrationSuccessful())
                    .build();
    }
}
