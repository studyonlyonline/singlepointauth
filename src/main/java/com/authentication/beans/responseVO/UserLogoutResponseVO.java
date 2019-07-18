package com.authentication.beans.responseVO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserLogoutResponseVO {
    @JsonProperty(value = "meta")
    private ResponseMetaNode metaNode;
}
