package com.authentication.beans.responseVO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseMetaNode {

    @JsonProperty(value = "statusCode")
    private String statusCode;
    @JsonProperty(value = "statusMessage")
    private String statusMessage;
    @JsonProperty(value = "developerMessage")
    private String developerMessage;
    @JsonProperty(value = "timestamp")
    private LocalDateTime timestamp;

}
