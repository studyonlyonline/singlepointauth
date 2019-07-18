package com.authentication.service.common;

import com.authentication.beans.businessBO.UserLoginByEmailBO;
import com.authentication.beans.responseVO.UserLoginResponseVO;

public interface IUserLoginService {

    public UserLoginResponseVO loginUserByEmail(UserLoginByEmailBO userLoginByEmailBO);

}
