package com.authentication.service.common.impl;

import com.authentication.db.dao.IUserRepository;
import com.authentication.db.entity.UserEntity;
import com.authentication.requestVO.UserRegistrationVO;
import com.authentication.service.common.IUserRegistrationService;
import com.authentication.service.common.convertors.UserRegistrationConvertor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserRegistrationServiceImpl implements IUserRegistrationService {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private UserRegistrationConvertor userRegistrationConvertor;

    @Override
    public boolean registerUserByEmail(UserRegistrationVO userRegistrationVO) {
        if (userRepository.findByEmail(userRegistrationVO.getEmail()).size() > 0){
            log.error("User Registration failed, email already exists");
            return false;
        }
        UserEntity newUser = userRegistrationConvertor.convertUserRegistrationVOToEntity(userRegistrationVO);
        userRepository.save(newUser);
        return true;
    }
}
