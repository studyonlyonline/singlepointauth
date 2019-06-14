package com.authentication.db.dao.impl;

import com.authentication.db.dao.IUserRepositoryCustom;
import com.authentication.db.entity.UserEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


public class IUserRepositoryCustomImpl implements IUserRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public UserEntity findFirstUserByEmail(String email) {
        UserEntity userEntity = (UserEntity) entityManager.createQuery("from UserEntity where email =: emailId")
                .setParameter("emailId", email)
                .getSingleResult();
        return userEntity;
    }

    @Override
    public UserEntity verifyPassword(String email, String password) {
        UserEntity userEntity = (UserEntity) entityManager
                .createQuery("from UserEntity where email =: emailId and password =: password")
                .setParameter("emailId", email)
                .setParameter("password", password)
                .getSingleResult();
        return userEntity;
    }
}
