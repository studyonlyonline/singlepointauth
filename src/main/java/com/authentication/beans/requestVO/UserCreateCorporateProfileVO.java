package com.authentication.beans.requestVO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserCreateCorporateProfileVO {

    @JsonProperty(value = "ssoToken")
    private String ssoToken;
    @JsonProperty(value = "email")
    private String emailId;
    @JsonProperty(value = "organizationId")
    private String organizationId;
    @JsonProperty(value = "userId")
    private Long userId;
    @JsonProperty(value = "firmName")
    private String firmName;
    @JsonProperty(value = "gstin")
    private String gstin;
    @JsonProperty(value = "aadharNo")
    private String aadharNo;
    @JsonProperty(value = "billingAddress")
    private String billingAddress;

}
