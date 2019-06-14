package com.authentication.db.entity;

import com.authentication.beans.LoginStatusEnums;
import com.authentication.beans.UserType;
import com.authentication.beans.UserTypeEnum;
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
    @Column(name = "loginId")
    private Long loginId;
    @Column(name = "sso_token")
    private String ssoToken;
    @Column(name = "user_id")
    private Long userId;
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

    public UserLoginInfoEntity(Long userId, String ssoToken, String emailId, LoginStatusEnums loginStatus, UserTypeEnum userType){
        this.userId = userId;
        this.ssoToken = ssoToken;
        this.emailId = emailId;
        this.loginStatus = loginStatus;
        this.userType = userType;
        this.createdOn = LocalDateTime.now();
    }
}
