package com.authentication.controller;

import com.authentication.businessBO.UserLoginByEmailBO;
import com.authentication.requestVO.LoginByEmailVO;
import com.authentication.requestVO.UserRegistrationVO;
import com.authentication.service.common.IUserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login-service/")
public class UserLoginController {

    @Autowired
    private IUserLoginService userLoginService;

    @PostMapping(value = "/login")
    public String loginByEmail(@RequestBody LoginByEmailVO loginByEmailVO){
        UserLoginByEmailBO userLoginByEmailBO = new UserLoginByEmailBO(loginByEmailVO.getEmail(), loginByEmailVO.getPassword());
        return userLoginService.loginUserByEmail(userLoginByEmailBO);

    }

}
