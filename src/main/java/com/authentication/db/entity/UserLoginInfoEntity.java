package com.authentication.db.entity;

import com.authentication.beans.constants.LoginStatusEnums;
import com.authentication.beans.constants.UserTypeEnum;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@Entity
@Table(name = "user_login_info")
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "login_id")
    private Long loginId;
    @Column(name = "sso_token")
    private String ssoToken;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "organization_id")
    private String organizationId;
    @Column(name = "email")
    private String emailId;
    @Column(name = "login_status")
    @Enumerated(EnumType.STRING)
    private LoginStatusEnums loginStatus;
    @Column(name = "user_type")
    @Enumerated(EnumType.STRING)
    private UserTypeEnum userType;
    @Column(name = "created_on")
    private LocalDateTime createdOn;
    @Column(name = "modified_on")
    private LocalDateTime modifiedOn;

    public UserLoginInfoEntity(Long userId, String organizationId, String ssoToken, String emailId, LoginStatusEnums loginStatus, UserTypeEnum userType){
        this.userId = userId;
        this.organizationId = organizationId;
        this.ssoToken = ssoToken;
        this.emailId = emailId;
        this.loginStatus = loginStatus;
        this.userType = userType;
        this.createdOn = LocalDateTime.now();
    }
}
