package com.authentication.db.dao;

import com.authentication.db.entity.UserEntity;

public interface IUserRepositoryCustom {

    UserEntity findFirstUserByEmail(String email, String organizationId);

    UserEntity verifyPassword(String email, String password, String organizationId);

    UserEntity getUserEntityFromEmailOrSso(String email, String ssoToken, String organizationId);
}
