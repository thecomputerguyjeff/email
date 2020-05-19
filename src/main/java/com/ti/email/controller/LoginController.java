package com.ti.email.controller;

import com.ti.email.model.Login;
import com.ti.email.model.UserID;
import com.ti.email.service.LoginService;
import com.ti.email.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class LoginController {

    private final LoginService loginService;
    public LoginController(LoginService loginService){
        this.loginService = loginService;
    }

    @PostMapping(value="/login")
    public UserID login(@RequestBody Login credentials){
        return loginService.login(credentials);
    }

}
