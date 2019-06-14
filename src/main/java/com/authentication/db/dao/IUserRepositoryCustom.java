package com.authentication.db.dao;

import com.authentication.db.entity.UserEntity;

public interface IUserRepositoryCustom {

    UserEntity findFirstUserByEmail(String email);

    UserEntity verifyPassword(String email, String password);
}
