package com.authentication.db.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@Entity
@Table(name = "user_profile")
@NoArgsConstructor
@AllArgsConstructor
public class UserProfileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profile_id")
    private Long profileId;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "email")
    private String email;
    @Column(name = "organization_id")
    private String organizationId;
    @Column(name = "firstname")
    private String  firstname;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "address")
    private String address;
    @Column(name = "pincode")
    private String pincode;
    @Column(name = "is_profile_verified")
    private Boolean profileVerified=false;
    @Column(name = "created_on")
    private LocalDateTime createdOn;
    @Column(name = "modified_on")
    private LocalDateTime modifiedOn;

}
