package com.authentication.db.dao.impl;

import com.authentication.db.dao.IUserRepositoryCustom;
import com.authentication.db.dao.UserLoginInfoRepository;
import com.authentication.db.entity.UserEntity;
import com.authentication.db.entity.UserLoginInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Objects;


public class IUserRepositoryCustomImpl implements IUserRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    UserLoginInfoRepository userLoginInfoRepository;

    @Override
    public UserEntity findFirstUserByEmail(String email, String organizationId) {
        List<UserEntity> userEntity = entityManager.createQuery("from UserEntity where email =: emailId " +
                "and organizationId =: organizationId" )
                .setParameter("emailId", email)
                .setParameter("organizationId", organizationId)
                .setMaxResults(1)
                .getResultList();
        if (userEntity.size() == 0){
            return null;
        }
        return userEntity.get(0);
    }

    @Override
    public UserEntity verifyPassword(String email, String password, String organizationId) {
        List<UserEntity> userEntities = entityManager
                .createQuery("from UserEntity where email =: emailId and password =: password " +
                        "and organizationId =: organizationId")
                .setParameter("emailId", email)
                .setParameter("password", password)
                .setParameter("organizationId", organizationId)
                .setMaxResults(1)
                .getResultList();
        if(userEntities.size() == 0){
            return null;
        }
        return userEntities.get(0);
    }

    @Override
    public UserEntity getUserEntityFromEmailOrSso(String email, String ssoToken, String organizationId){
        if (null != email && !"".equalsIgnoreCase(email) && null != organizationId && !"".equalsIgnoreCase(organizationId)){
            UserEntity userEntity = findFirstUserByEmail(email, organizationId);
            return userEntity;
        }
        if (ssoToken == null){
            return null;
        }
        UserLoginInfoEntity userLoginInfoEntity = userLoginInfoRepository.getUserLoginInfoFromSsoToken(ssoToken);
        if(Objects.isNull(userLoginInfoEntity.getEmailId())){
            return null;
        }
        UserEntity userEntity = findFirstUserByEmail(userLoginInfoEntity.getEmailId(), userLoginInfoEntity.getOrganizationId());
        return userEntity;
    }
}
