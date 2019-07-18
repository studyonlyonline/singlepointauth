package com.authentication.beans.responseVO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserLoginResponseDataNode {
    private String emailId;
    private String ssoToken;
}
