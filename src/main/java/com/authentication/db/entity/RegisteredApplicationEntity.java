package com.authentication.db.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "organizations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisteredApplicationEntity {
    private static final long serialVersionUID = 15L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "application_id")
    private Long id;

    @Column(name = "application_name")
    private String applicationName;

    @Column(name = "application_user_email")
    private String applicationUserEmail;

    @Column(name = "api_key", unique = true)
    private String apiKey;

    @Column(name = "created_on")
    private LocalDateTime createdOn;
    @Column(name = "modified_on")
    private LocalDateTime modifiedOn;
    @Column(name = "is_account_deleted")
    private Boolean isAccountDeleted;

}
