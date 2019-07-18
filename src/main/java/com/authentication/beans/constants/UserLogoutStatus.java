package com.authentication.beans.constants;

import lombok.Getter;

@Getter
public enum UserLogoutStatus {

    SUCCESSFULLY_LOGGED_OUT("200", "Successfully logged out",true),
    FAILURE_LOGGING_OUT("404","Failed to log out. Not found.", false);

    private boolean status;
    private String statusCode;
    private String statusMessage;
    private String httpCode;
    private String developerMessage;

    private UserLogoutStatus(String statusCode, String statusMessage, boolean status) {
        this.status = status;
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
    }

}
