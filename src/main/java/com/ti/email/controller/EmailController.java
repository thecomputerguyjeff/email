package com.ti.email.controller;

import org.springframework.web.bind.annotation.*;
import com.ti.email.model.Email;



import com.ti.email.service.EmailService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class EmailController {
    private final EmailService emailService;
    public EmailController(EmailService emailService){
        this.emailService = emailService;
    }


    @PostMapping("/sendEmail")//sends an email
    public Email sendEmail(@RequestBody Email email) {
        return emailService.sendEmail(email);
    }

    @GetMapping(value = "/getEmail/{emailId}")//gets a whole email object when pass in the object_id
    public Email getEmail(@PathVariable String emailId){
        return emailService.getEmailBy_id(emailId);
    }



}
