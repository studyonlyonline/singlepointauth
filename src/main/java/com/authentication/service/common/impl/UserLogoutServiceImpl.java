package com.authentication.service.common.impl;

import com.authentication.beans.businessBO.UserLogoutBO;
import com.authentication.beans.constants.LoginStatusEnums;
import com.authentication.beans.responseVO.UserLoginResponseDataNode;
import com.authentication.beans.responseVO.UserLoginResponseVO;
import com.authentication.beans.responseVO.UserLogoutResponseVO;
import com.authentication.beans.responseVO.responseGeneratorUtils.ResponseBuilderUtils;
import com.authentication.db.dao.UserLoginInfoRepository;
import com.authentication.db.entity.UserLoginInfoEntity;
import com.authentication.service.common.IUserLogoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;

@Service
public class UserLogoutServiceImpl implements IUserLogoutService {

    @Autowired
    private UserLoginInfoRepository userLoginInfoRepository;

    @Override
    public UserLogoutResponseVO logoutUser(UserLogoutBO userLogoutBO) {
        UserLoginInfoEntity userLoginInfo = userLoginInfoRepository.getLoggedInUser(userLogoutBO.getEmailId(),
                userLogoutBO.getSsoToken());
        if(userLoginInfo != null){
            userLoginInfo.setLoginStatus(LoginStatusEnums.LOGGED_OUT);
            userLoginInfo.setModifiedOn(LocalDateTime.now());
            userLoginInfo = userLoginInfoRepository.save(userLoginInfo);
        }
        return prepareResponse(userLoginInfo);
    }

    private UserLogoutResponseVO prepareResponse(UserLoginInfoEntity userLoginInfoEntity){
        if(Objects.isNull(userLoginInfoEntity) || Objects.isNull(userLoginInfoEntity.getLoginId())){
            return UserLogoutResponseVO.builder()
                    .metaNode(ResponseBuilderUtils.logoutExceptionResponse404MetaNode())
                    .build();
        }
        return UserLogoutResponseVO.builder()
                .metaNode(ResponseBuilderUtils.logoutSuccessResponseMetaNode())
                .build();
    }
}
