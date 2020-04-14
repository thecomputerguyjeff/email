package com.ti.email.service;

import com.ti.email.model.Email;
import com.ti.email.repository.MongoDBEmailRepository;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    private final MongoDBEmailRepository mongoDBEmailRepository;
    public EmailService(MongoDBEmailRepository mongoDBEmailRepository){
        this.mongoDBEmailRepository=mongoDBEmailRepository;
    }
    public Email getEmailBy_id(String emailId) {
        return mongoDBEmailRepository.getEmailBy_id(emailId);

    }

    public Email sendEmail(Email email) {
        return mongoDBEmailRepository.sendEmail(email);
    }
}
