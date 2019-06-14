package com.authentication.service.common.impl;

import com.authentication.beans.LoginStatusEnums;
import com.authentication.beans.UserType;
import com.authentication.beans.UserTypeEnum;
import com.authentication.businessBO.UserLoginByEmailBO;
import com.authentication.db.dao.UserLoginInfoRepository;
import com.authentication.db.dao.IUserRepository;
import com.authentication.db.entity.UserEntity;
import com.authentication.db.entity.UserLoginInfoEntity;
import com.authentication.service.common.IUserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserLoginServiceImpl implements IUserLoginService {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private UserLoginInfoRepository userLoginInfoRepository;

    @Override
    public String loginUserByEmail(UserLoginByEmailBO userLoginByEmailBO) {
        UserEntity user = userRepository.verifyPassword(userLoginByEmailBO.getEmailId(),
                userLoginByEmailBO.getPassword());
        if(user == null ){
            return "failure";
        }
        String ssoToken = UUID.randomUUID().toString();
        UserLoginInfoEntity userLoginInfoEntity = new UserLoginInfoEntity(user.getUserId(),
                ssoToken,
                userLoginByEmailBO.getEmailId(),
                LoginStatusEnums.LOGGED_IN,
                UserTypeEnum.NORMAL);
        userLoginInfoEntity = userLoginInfoRepository.save(userLoginInfoEntity);
        return userLoginInfoEntity.getLoginId() + " " + userLoginInfoEntity.getSsoToken();

    }

}
