package com.authentication.db.entity;

import com.authentication.beans.constants.UserTypeEnum;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@Entity
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "organization_id")
    private String organizationId;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "mobile_no")
    private String mobileNo;
    @Column(name = "mobile_isd_code")
    private String mobileISDCode;
    @Column(name = "is_email_verified")
    private Boolean isEmailVerified;
    @Column(name = "is_mobile_verified")
    private Boolean isMobileVerified;
    @Column(name = "user_type")
    @Enumerated(EnumType.STRING)
    private UserTypeEnum userType;
    @Column(name = "created_on")
    private LocalDateTime createdOn;
    @Column(name = "modified_on")
    private LocalDateTime modifiedOn;
    @Column(name = "is_account_deleted")
    private Boolean isAccountDeleted;
}
