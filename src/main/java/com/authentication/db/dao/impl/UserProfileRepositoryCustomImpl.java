package com.authentication.db.dao.impl;

import com.authentication.beans.constants.LoginStatusEnums;
import com.authentication.db.dao.UserProfileRepositoryCustom;
import com.authentication.db.entity.UserLoginInfoEntity;
import com.authentication.db.entity.UserProfileEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class UserProfileRepositoryCustomImpl implements UserProfileRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public UserProfileEntity findUserByEmailAndOrganization(String email, String organizationId) {
        List<UserProfileEntity> userProfileEntities = entityManager
                .createQuery("from UserProfileEntity where email =: email " +
                        "and organizationId =: organizationId")
                .setParameter("email",email)
                .setParameter("organizationId", organizationId)
                .setMaxResults(1)
                .getResultList();
        if (userProfileEntities.size()==0){
            return null;
        }
        return userProfileEntities.get(0);
    }



}
