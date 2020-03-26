package com.ti.email.controller;

import com.ti.email.model.Email;
import com.ti.email.model.User;
import com.ti.email.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class UserController {
//    @Autowired
//    private UserService userService;

    private final UserService userService;
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping(value="/getInbox/{userID}")
    public List<Email> getMyInbox(@PathVariable String userID){
        return userService.getMyInbox(userID);
    }

//    @PostMapping(value = "/saveUser")
//    public User saveUser(@RequestBody User user){
//        return userService.save(user);
//    }
}
