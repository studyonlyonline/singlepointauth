package com.authentication.beans.requestVO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserLoginInfoVO {
    @JsonProperty(value = "ssoToken")
    private String ssoToken;
    @JsonProperty(value = "email")
    private String emailId;
    @JsonProperty(value = "organizationId")
    private String organizationId;


}
