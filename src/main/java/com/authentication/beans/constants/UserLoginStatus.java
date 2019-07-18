package com.authentication.beans.constants;

import lombok.Getter;
import lombok.Setter;

@Getter
public enum UserLoginStatus {
    SUCCESSFULLY_LOGGED_IN("200", "Successfully logged in.",true),
    FAILURE_LOGGING_IN("404","Failed to log in. Not found.", false);

    private boolean status;
    private String statusCode;
    private String statusMessage;
    private String httpCode;
    private String developerMessage;

    private UserLoginStatus(String statusCode, String statusMessage, boolean status) {
        this.status = status;
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
    }

}
