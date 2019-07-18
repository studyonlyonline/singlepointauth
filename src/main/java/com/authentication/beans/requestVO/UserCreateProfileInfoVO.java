package com.authentication.beans.requestVO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserCreateProfileInfoVO {
    @JsonProperty(value = "ssoToken")
    private String ssoToken;
    @JsonProperty(value = "emailId")
    private String emailId;
    @JsonProperty(value = "organizationId")
    private String organizationId;
    @JsonProperty(value = "userId")
    private Long userId;
    @JsonProperty(value = "firstname", required = true)
    private String firstname;
    @JsonProperty(value = "lastname")
    private String lastname;
    @JsonProperty(value = "address")
    private String address;
    @JsonProperty(value = "pincode")
    private String pincode;
}
