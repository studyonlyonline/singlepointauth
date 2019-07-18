package com.authentication.db.dao.impl;

import com.authentication.beans.constants.LoginStatusEnums;
import com.authentication.db.dao.UserLoginInfoRepositoryCustom;
import com.authentication.db.entity.UserLoginInfoEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class UserLoginInfoRepositoryCustomImpl implements UserLoginInfoRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public UserLoginInfoEntity getLoggedInUser(String emailId, String ssoToken) {
        List<UserLoginInfoEntity> userLoginInfoEntities = entityManager
                .createQuery("from UserLoginInfoEntity where emailId =: emailId " +
                        "and ssoToken =: ssoToken " +
                        "and loginStatus =: loginStatus")
                .setParameter("emailId", emailId)
                .setParameter("ssoToken", ssoToken)
                .setParameter("loginStatus", LoginStatusEnums.LOGGED_IN)
                .setMaxResults(1)
                .getResultList();
        if(userLoginInfoEntities.size() == 0){
            return null;
        }
        return userLoginInfoEntities.get(0);
    }

    @Override
    public UserLoginInfoEntity getUserLoginInfoFromSsoToken(String ssoToken) {
        List<UserLoginInfoEntity> userLoginInfoEntities = entityManager
                .createQuery("from UserLoginInfoEntity where ssoToken =: ssoToken ")
                .setParameter("ssoToken", ssoToken)
                .setMaxResults(1)
                .getResultList();
        if(userLoginInfoEntities.size() == 0){
            return null;
        }
        return userLoginInfoEntities.get(0);
    }


}
