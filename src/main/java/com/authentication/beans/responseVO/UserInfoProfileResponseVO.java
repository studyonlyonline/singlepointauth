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
public class UserInfoProfileResponseVO {
    @JsonProperty(value = "firstName")
    private String firstName;
    @JsonProperty(value = "lastName")
    private String lastName;
    @JsonProperty(value = "address")
    private String address;
    @JsonProperty(value = "pincode")
    private String pincode;
    @JsonProperty(value = "verifiedProfile")
    private Boolean verifiedProfile;
}
