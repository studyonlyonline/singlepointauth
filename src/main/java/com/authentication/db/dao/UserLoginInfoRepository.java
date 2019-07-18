package com.authentication.db.dao;

import com.authentication.db.entity.UserLoginInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLoginInfoRepository extends JpaRepository<UserLoginInfoEntity, Long> , UserLoginInfoRepositoryCustom{


}
