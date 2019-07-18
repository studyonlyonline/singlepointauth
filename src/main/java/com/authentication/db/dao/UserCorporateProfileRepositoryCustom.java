package com.authentication.db.dao;

import com.authentication.db.entity.UserCorporateProfileEntity;
import com.authentication.db.entity.UserProfileEntity;

public interface UserCorporateProfileRepositoryCustom {

    UserCorporateProfileEntity findUserByEmailAndOrganization(String email, String organizationId);
}
