package com.authentication.db.dao;

import com.authentication.db.entity.UserCorporateProfileEntity;
import com.authentication.db.entity.UserProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCorporateProfileRepository extends JpaRepository<UserCorporateProfileEntity, Long>, UserCorporateProfileRepositoryCustom{
}
