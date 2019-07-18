package com.authentication.beans.responseVO;

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
public class UserInfoCorporateProfileResponseVO {
    @JsonProperty(value = "firmName")
    private String firmName;
    @JsonProperty(value = "gstin")
    private String gstin;
    @JsonProperty(value = "aadharNo")
    private String aadharNo;
    @JsonProperty(value = "billingAddress")
    private String billingAddress;
    @JsonProperty(value = "corporateProfileVerified")
    private Boolean corporateProfileVerified;


}
