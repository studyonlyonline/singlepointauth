package com.authentication.beans.responseVO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserInfoResponseVO {
    @JsonProperty(value = "meta")
    private ResponseMetaNode metaNode;
    @JsonProperty(value = "data")
    private UserInfoResponseDataNode userInfoResponseDataNode;
}
