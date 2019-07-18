package com.authentication.beans.responseVO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserInfoResponseDataNode {

    @JsonProperty(value = "email")
    private String email;
    @JsonProperty(value = "mobileNo")
    private String mobileNo;
    @JsonProperty(value = "mobileIsdCode")
    private String mobileIsdCode;
    @JsonProperty(value = "emailVerified")
    private Boolean emailVerified ;
    @JsonProperty(value = "mobileVerfied")
    private Boolean mobileVerified;
    @JsonProperty(value = "userType")
    private String userType;
    @JsonProperty(value = "accountActive")
    private Boolean accountActive;

    @JsonProperty(value = "profile")
    private UserInfoProfileResponseVO userInfoProfileResponseVO;
    @JsonProperty(value = "corporateProfile")
    private UserInfoCorporateProfileResponseVO userInfoCorporateProfileResponseVO;

}
