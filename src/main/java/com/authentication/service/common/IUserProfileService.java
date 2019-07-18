package com.authentication.service.common;

import com.authentication.beans.requestVO.UserCreateCorporateProfileVO;
import com.authentication.beans.requestVO.UserCreateProfileInfoVO;
import com.authentication.beans.requestVO.UserLoginInfoVO;
import com.authentication.beans.responseVO.UserCreateProfileResponseVO;
import com.authentication.beans.responseVO.UserInfoResponseVO;
import com.authentication.db.entity.UserEntity;

public interface IUserProfileService {

    public UserCreateProfileResponseVO createNewProfile(UserCreateProfileInfoVO userCreateProfileInfoVO);

    public UserCreateProfileResponseVO createNewCorporateProfile(UserCreateCorporateProfileVO userCreateCorporateProfileVO);

    public UserInfoResponseVO getUserInfo(UserLoginInfoVO userLoginInfoVO);
}
