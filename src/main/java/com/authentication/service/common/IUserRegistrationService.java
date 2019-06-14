package com.authentication.service.common;

import com.authentication.requestVO.UserRegistrationVO;

public interface IUserRegistrationService {

    public boolean registerUserByEmail(UserRegistrationVO userRegistrationVO);

}
