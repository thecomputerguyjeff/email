package com.ti.email.service;

import com.ti.email.model.Email;
import com.ti.email.repository.MongoDBEmailRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailService {
    private final MongoDBEmailRepository mongoDBEmailRepository;

    public EmailService(MongoDBEmailRepository mongoDBEmailRepository) {
        this.mongoDBEmailRepository = mongoDBEmailRepository;
    }

    public Email getEmailBy_id(String emailId) {
        return mongoDBEmailRepository.getEmailBy_id(emailId);

    }

    public Email save(Email email) {
        return mongoDBEmailRepository.save(email);
    }
    public String errorMessage(){
        return "error!invalid input! please try again";
    }
//    public List<Email> getSentByBy_Id(String userId){
//        return mongoDBEmailRepository.getSentByBy_Id(userId);
//    }
}
