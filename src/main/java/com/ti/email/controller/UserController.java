package com.ti.email.controller;

import com.ti.email.model.Email;
import com.ti.email.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class UserController {

    private final UserService userService;
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping(value="/getInbox/{userID}")
    public List<Email> getMyInbox(@PathVariable String userID){
        return userService.getMyInbox(userID);
    }

}
