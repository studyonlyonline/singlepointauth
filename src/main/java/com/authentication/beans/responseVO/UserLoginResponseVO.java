package com.authentication.beans.responseVO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserLoginResponseVO {
    @JsonProperty(value = "meta")
    private ResponseMetaNode metaNode;
    @JsonProperty(value = "data")
    private UserLoginResponseDataNode userLoginResponseDataNode;
}
