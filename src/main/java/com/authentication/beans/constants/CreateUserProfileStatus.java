package com.authentication.beans.constants;

import lombok.Getter;

@Getter
public enum CreateUserProfileStatus {
    SUCCESSFULLY_PROFILE_CREATED("200", "Successfully Profile Created.",true),
    FAILURE_CREATING_PROFILE("500","Failed to Create Profile.", false);

    private boolean status;
    private String statusCode;
    private String statusMessage;
    private String httpCode;
    private String developerMessage;

    private CreateUserProfileStatus(String statusCode, String statusMessage, boolean status) {
        this.status = status;
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
    }

}