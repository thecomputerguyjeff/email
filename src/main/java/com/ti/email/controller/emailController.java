package com.ti.email.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Email;

@RestController
@CrossOrigin

public class emailController {

    @PostMapping("/sendAnEmail")
    public void scanAnItem( @RequestBody EmailDetails emailDetails) throws IllegalAccessException {
        Email email = new Email(emailDetails.emailId, emailDetails.sendToEmailAddress, emailDetails.sentFromEmailAddress,
                emailDetails.subject, emailDetails.emailText);
    }
}
