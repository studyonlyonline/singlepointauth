package com.authentication.service.common.impl;

import com.authentication.beans.constants.LoginStatusEnums;
import com.authentication.beans.constants.UserTypeEnum;
import com.authentication.beans.businessBO.UserLoginByEmailBO;
import com.authentication.beans.responseVO.UserLoginResponseDataNode;
import com.authentication.beans.responseVO.UserLoginResponseVO;
import com.authentication.beans.responseVO.responseGeneratorUtils.ResponseBuilderUtils;
import com.authentication.db.dao.UserLoginInfoRepository;
import com.authentication.db.dao.IUserRepository;
import com.authentication.db.entity.UserEntity;
import com.authentication.db.entity.UserLoginInfoEntity;
import com.authentication.service.common.IUserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

@Service
public class UserLoginServiceImpl implements IUserLoginService {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private UserLoginInfoRepository userLoginInfoRepository;

    @Override
    public UserLoginResponseVO loginUserByEmail(UserLoginByEmailBO userLoginByEmailBO) {
        UserEntity user = userRepository.verifyPassword(userLoginByEmailBO.getEmailId(),
                userLoginByEmailBO.getPassword(), userLoginByEmailBO.getOrganizationId());
        if(user == null ){
            return prepareLoginResponse(null);
        }
        String ssoToken = UUID.randomUUID().toString();
        UserLoginInfoEntity userLoginInfoEntity = new UserLoginInfoEntity(user.getUserId(),
                user.getOrganizationId(),
                ssoToken,
                userLoginByEmailBO.getEmailId(),
                LoginStatusEnums.LOGGED_IN,
                UserTypeEnum.NORMAL);
        userLoginInfoEntity = userLoginInfoRepository.save(userLoginInfoEntity);
        UserLoginResponseVO userLoginResponseVO = prepareLoginResponse(userLoginInfoEntity);
        return userLoginResponseVO;
    }

    private UserLoginResponseVO prepareLoginResponse(UserLoginInfoEntity userLoginInfoEntity){
        if(Objects.isNull(userLoginInfoEntity) || Objects.isNull(userLoginInfoEntity.getLoginId())){
            return UserLoginResponseVO.builder()
                    .metaNode(ResponseBuilderUtils.loginExceptionResponse404MetaNode())
                    .build();
        }
        return UserLoginResponseVO.builder()
                .metaNode(ResponseBuilderUtils.loginSuccessResponseMetaNode())
                .userLoginResponseDataNode(
                        UserLoginResponseDataNode.builder()
                        .emailId(userLoginInfoEntity.getEmailId())
                        .ssoToken(userLoginInfoEntity.getSsoToken())
                        .build())
                .build();
    }

}
