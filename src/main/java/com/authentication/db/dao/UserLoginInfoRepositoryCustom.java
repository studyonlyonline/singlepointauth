package com.authentication.db.dao;

import com.authentication.db.entity.UserLoginInfoEntity;

public interface UserLoginInfoRepositoryCustom {

    UserLoginInfoEntity getLoggedInUser(String emailId, String ssoToken);

    UserLoginInfoEntity getUserLoginInfoFromSsoToken(String ssoToken);

}
