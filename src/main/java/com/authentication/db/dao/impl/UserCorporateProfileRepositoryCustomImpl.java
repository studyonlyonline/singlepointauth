package com.authentication.db.dao.impl;

import com.authentication.db.dao.UserCorporateProfileRepositoryCustom;
import com.authentication.db.entity.UserCorporateProfileEntity;
import com.authentication.db.entity.UserProfileEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class UserCorporateProfileRepositoryCustomImpl implements UserCorporateProfileRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public UserCorporateProfileEntity findUserByEmailAndOrganization(String email, String organizationId) {
        List<UserCorporateProfileEntity> userCorporateProfileEntities = entityManager
                .createQuery("from UserCorporateProfileEntity where email =: email " +
                        "and organizationId =: organizationId")
                .setParameter("email",email)
                .setParameter("organizationId", organizationId)
                .setMaxResults(1)
                .getResultList();
        if (userCorporateProfileEntities.size()==0){
            return null;
        }
        return userCorporateProfileEntities.get(0);
    }

}
