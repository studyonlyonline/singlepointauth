package com.authentication.service.common;

import com.authentication.beans.businessBO.UserLoginByEmailBO;
import com.authentication.beans.businessBO.UserLogoutBO;
import com.authentication.beans.responseVO.UserLoginResponseVO;
import com.authentication.beans.responseVO.UserLogoutResponseVO;

public interface IUserLogoutService {

    public UserLogoutResponseVO logoutUser(UserLogoutBO userLogoutBO);

}
