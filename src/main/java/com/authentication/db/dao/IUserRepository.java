package com.authentication.db.dao;

import com.authentication.db.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity, Long>, IUserRepositoryCustom {
    List<UserEntity> findByEmailAndOrganizationId(String email, String organizationId);

//    @Query("SELECT u from UserEntity u where u.email = :emailId")
//    UserEntity findOnlyOneUserByEmail(@Param("emailId") String email);

}
