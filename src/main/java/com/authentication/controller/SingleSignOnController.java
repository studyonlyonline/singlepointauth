package com.authentication.controller;

import com.authentication.beans.businessBO.UserLoginByEmailBO;
import com.authentication.beans.businessBO.UserLogoutBO;
import com.authentication.beans.requestVO.*;
import com.authentication.beans.responseVO.*;
import com.authentication.service.common.IUserLoginService;
import com.authentication.service.common.IUserLogoutService;
import com.authentication.service.common.IUserProfileService;
import com.authentication.service.common.IUserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/service/")
public class SingleSignOnController {

    @Autowired
    private IUserRegistrationService userRegistrationService;

    @Autowired
    private IUserLoginService userLoginService;

    @Autowired
    private IUserLogoutService userLogoutService;

    @Autowired
    private IUserProfileService userProfileService;

    @PostMapping(value = "/registerUser")
    public UserRegisterResponseVO registerUser(@RequestBody UserRegistrationVO userRegistrationVO){
        return userRegistrationService.registerUserByEmail(userRegistrationVO);
    }

    @PostMapping(value = "/login")
    public UserLoginResponseVO loginByEmail(@RequestBody LoginByEmailVO loginByEmailVO){
        UserLoginByEmailBO userLoginByEmailBO = new UserLoginByEmailBO(loginByEmailVO.getEmail(),
                loginByEmailVO.getPassword(),
                loginByEmailVO.getOrganizationId());
        return userLoginService.loginUserByEmail(userLoginByEmailBO);
    }

    @PostMapping(value = "/logout")
    public UserLogoutResponseVO logout(@RequestBody LogoutVO logoutVO){
        UserLogoutBO userLogoutBO = new UserLogoutBO(logoutVO.getEmailId(), logoutVO.getSsoToken());
        return userLogoutService.logoutUser(userLogoutBO);
    }

    @PostMapping(value = "/create-profile")
    public UserCreateProfileResponseVO createProfile(@RequestBody UserCreateProfileInfoVO userCreateProfileInfoVO){
        return userProfileService.createNewProfile(userCreateProfileInfoVO);
    }

    @PostMapping(value = "/create-corporate-profile")
    public UserCreateProfileResponseVO createCorporateProfile(@RequestBody UserCreateCorporateProfileVO userCreateCorporateProfileVO){
        return userProfileService.createNewCorporateProfile(userCreateCorporateProfileVO);
    }

    @PostMapping(value = "/user-profile")
    public UserInfoResponseVO getUserInfo(@RequestBody UserLoginInfoVO userLoginInfoVO){
        return userProfileService.getUserInfo(userLoginInfoVO);
    }

    @GetMapping(value = "/testGet")
    public String testGetRequest(){
        return "test";
    }

}
