package com.authentication.beans.constants;

import lombok.Getter;

@Getter
public enum UserRegistrationStatus {

    SUCCESSFULLY_REGISTRATION("200", "Registration Successful.",true),
    FAILURE_REGISTRATION("500","Registration Failed.", false);

    private boolean status;
    private String statusCode;
    private String statusMessage;
    private String httpCode;
    private String developerMessage;

    private UserRegistrationStatus(String statusCode, String statusMessage, boolean status) {
        this.status = status;
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
    }

}
