package com.authentication.db.dao;

import com.authentication.db.entity.UserProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository<UserProfileEntity, Long>, UserProfileRepositoryCustom {



}
