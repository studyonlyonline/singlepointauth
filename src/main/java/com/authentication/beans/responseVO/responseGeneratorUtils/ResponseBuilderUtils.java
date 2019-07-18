package com.authentication.beans.responseVO.responseGeneratorUtils;

import com.authentication.beans.constants.*;
import com.authentication.beans.responseVO.ResponseMetaNode;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

public class ResponseBuilderUtils {

    public static ResponseMetaNode loginExceptionResponse404MetaNode(){
        return ResponseMetaNode.builder()
                .statusCode(UserLoginStatus.FAILURE_LOGGING_IN.getStatusCode())
                .statusMessage(UserLoginStatus.FAILURE_LOGGING_IN.getStatusMessage())
                .timestamp(LocalDateTime.now())
                .build();
    }

    public static ResponseMetaNode loginSuccessResponseMetaNode(){
        return ResponseMetaNode.builder()
                .statusCode(UserLoginStatus.SUCCESSFULLY_LOGGED_IN.getStatusCode())
                .statusMessage(UserLoginStatus.SUCCESSFULLY_LOGGED_IN.getStatusMessage())
                .timestamp(LocalDateTime.now())
                .build();
    }

    public static ResponseMetaNode logoutExceptionResponse404MetaNode(){
        return ResponseMetaNode.builder()
                .statusCode(UserLogoutStatus.FAILURE_LOGGING_OUT.getStatusCode())
                .statusMessage(UserLogoutStatus.FAILURE_LOGGING_OUT.getStatusMessage())
                .timestamp(LocalDateTime.now())
                .build();
    }

    public static ResponseMetaNode logoutSuccessResponseMetaNode(){
        return ResponseMetaNode.builder()
                .statusCode(UserLogoutStatus.SUCCESSFULLY_LOGGED_OUT.getStatusCode())
                .statusMessage(UserLogoutStatus.SUCCESSFULLY_LOGGED_OUT.getStatusMessage())
                .timestamp(LocalDateTime.now())
                .build();
    }

    public static ResponseMetaNode userProfileCreationFailed(String message){
        return ResponseMetaNode.builder()
                .statusCode(CreateUserProfileStatus.FAILURE_CREATING_PROFILE.getStatusCode())
                .statusMessage(!StringUtils.isEmpty(message) ? message : CreateUserProfileStatus.FAILURE_CREATING_PROFILE.getStatusMessage())
                .timestamp(LocalDateTime.now())
                .build();
    }

    public static ResponseMetaNode userProfileCreationSuccessful(){
        return ResponseMetaNode.builder()
                .statusCode(CreateUserProfileStatus.SUCCESSFULLY_PROFILE_CREATED.getStatusCode())
                .statusMessage(CreateUserProfileStatus.SUCCESSFULLY_PROFILE_CREATED.getStatusMessage())
                .timestamp(LocalDateTime.now())
                .build();
    }

    public static ResponseMetaNode userRegistrationSuccessful(){
        return ResponseMetaNode.builder()
                .statusCode(UserRegistrationStatus.SUCCESSFULLY_REGISTRATION.getStatusCode())
                .statusMessage(UserRegistrationStatus.SUCCESSFULLY_REGISTRATION.getStatusMessage())
                .timestamp(LocalDateTime.now())
                .build();
    }

    public static ResponseMetaNode userRegistrationFailed(String message){
        return ResponseMetaNode.builder()
                .statusCode(UserRegistrationStatus.FAILURE_REGISTRATION.getStatusCode())
                .statusMessage(message != null ? message : UserRegistrationStatus.FAILURE_REGISTRATION.getStatusMessage())
                .timestamp(LocalDateTime.now())
                .build();
    }

    public static ResponseMetaNode userCompleteInfoSuccess(){
        return ResponseMetaNode.builder()
                .statusCode(UserInfoStatus.SUCCESSFULLY_USER_INFO.getStatusCode())
                .statusMessage(UserInfoStatus.SUCCESSFULLY_USER_INFO.getStatusMessage())
                .timestamp(LocalDateTime.now())
                .build();
    }

    public static ResponseMetaNode userCompleteInfoFailed(String message){
        return ResponseMetaNode.builder()
                .statusCode(UserInfoStatus.FAILURE_USER_INFO.getStatusCode())
                .statusMessage(message != null ? message : UserInfoStatus.FAILURE_USER_INFO.getStatusMessage())
                .timestamp(LocalDateTime.now())
                .build();
    }

}
