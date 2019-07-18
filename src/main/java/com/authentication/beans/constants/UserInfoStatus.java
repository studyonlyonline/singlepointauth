package com.authentication.beans.constants;

import lombok.Getter;

@Getter
public enum UserInfoStatus {

    SUCCESSFULLY_USER_INFO("200", "Successful User Info fetched.",true),
    FAILURE_USER_INFO("500","User Info fetched failed.", false);

    private boolean status;
    private String statusCode;
    private String statusMessage;
    private String httpCode;
    private String developerMessage;

    private UserInfoStatus(String statusCode, String statusMessage, boolean status) {
        this.status = status;
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
    }
}
