package com.authentication.db.dao;

import com.authentication.db.entity.UserProfileEntity;

public interface UserProfileRepositoryCustom {

    UserProfileEntity findUserByEmailAndOrganization(String email, String organizationId);
}
