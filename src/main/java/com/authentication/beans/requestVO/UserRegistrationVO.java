package com.authentication.beans.requestVO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserRegistrationVO {
    private String name;
    private String email;
    private String password;
    private String organizationId;

    public UserRegistrationVO(String name, String email, String password, String organizationId) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.organizationId = organizationId;
    }

    public UserRegistrationVO() {
    }
}
