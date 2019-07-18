//package com.authentication.controller;
//
//import com.authentication.beans.businessBO.UserLoginByEmailBO;
//import com.authentication.beans.requestVO.LoginByEmailVO;
//import com.authentication.beans.responseVO.UserLoginResponseVO;
//import com.authentication.service.common.IUserLoginService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/login-service/")
//public class UserLoginController {
//
//    @Autowired
//    private IUserLoginService userLoginService;
//
//    @PostMapping(value = "/login")
//    public UserLoginResponseVO loginByEmail(@RequestBody LoginByEmailVO loginByEmailVO){
//        UserLoginByEmailBO userLoginByEmailBO = new UserLoginByEmailBO(loginByEmailVO.getEmail(), loginByEmailVO.getPassword());
//        return userLoginService.loginUserByEmail(userLoginByEmailBO);
//    }
//
//}
