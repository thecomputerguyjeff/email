package com.ti.email.controller;

import com.ti.email.service.UserEmail;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Email;

@RestController
@CrossOrigin

public class EmailController {
    public void userEmail(){
        userEmail = new UserEmail(//stuff
                 )
    }

    @PostMapping("/sendAnEmail")
    public void sendAnEmail( @RequestBody EmailDetails emailDetails) throws IllegalAccessException {
        Email email = new Email(emailDetails.emailId, emailDetails.sendToEmailAddress, emailDetails.sentFromEmailAddress,
                emailDetails.subject, emailDetails.emailText);
        email.sendAnEmail(stuff);
    }
}
