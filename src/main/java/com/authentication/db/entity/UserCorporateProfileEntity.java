package com.authentication.db.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@Entity
@Table(name = "user_corporate_profile")
@NoArgsConstructor
@AllArgsConstructor
public class UserCorporateProfileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "corporate_profile_id")
    private Long corporateProfileId;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "email")
    private String email;
    @Column(name = "organization_id")
    private String organizationId;
    @Column(name = "firm_name")
    private String  firmName;
    @Column(name = "GSTIN")
    private String gstin;
    @Column(name = "aadhar_no")
    private String aadharNo;
    @Column(name = "billing_address")
    private String billingAddress;
    @Column(name = "is_profile_verified")
    private Boolean profileVerified=false;
    @Column(name = "created_on")
    private LocalDateTime createdOn;
    @Column(name = "modified_on")
    private LocalDateTime modifiedOn;

}
