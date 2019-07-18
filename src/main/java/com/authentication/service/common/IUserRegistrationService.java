package com.authentication.service.common;

import com.authentication.beans.requestVO.UserRegistrationVO;
import com.authentication.beans.responseVO.UserRegisterResponseVO;

public interface IUserRegistrationService {

    public UserRegisterResponseVO registerUserByEmail(UserRegistrationVO userRegistrationVO);

}
