package com.authentication.service.common;

import com.authentication.beans.requestVO.UserRegistrationVO;

public interface IApplicationRegistrationService {

    public String registerNewApplication(UserRegistrationVO userRegistrationVO);

}
