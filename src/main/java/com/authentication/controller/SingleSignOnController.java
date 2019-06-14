package com.authentication.controller;

import com.authentication.requestVO.UserRegistrationVO;
import com.authentication.service.common.IUserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/service/")
public class SingleSignOnController {

    @Autowired
    IUserRegistrationService userRegistrationService;

    @PostMapping(value = "/registerUser")
    public String registerUser(@RequestBody UserRegistrationVO userRegistrationVO){
        userRegistrationService.registerUserByEmail(userRegistrationVO);
        return "Asd";
    }


}
