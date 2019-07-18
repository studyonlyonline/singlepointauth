package com.authentication.beans.requestVO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LogoutVO {
    @JsonProperty(value = "email")
    private String emailId;
    @JsonProperty(value = "ssoToken")
    private String ssoToken;
}
