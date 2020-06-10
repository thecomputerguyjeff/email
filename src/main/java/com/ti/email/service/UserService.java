package com.ti.email.service;

import com.ti.email.model.Email;
import com.ti.email.model.User;
import com.ti.email.repository.MongoDBEmailRepository;
import com.ti.email.repository.MongoDBUserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {

    private final MongoDBEmailRepository mongoDBEmailRepository;
    private final MongoDBUserRepository mongoDBUserRepository;
    public UserService(MongoDBUserRepository mongoDBUserRepository,MongoDBEmailRepository mongoDBEmailRepository){
        this.mongoDBUserRepository = mongoDBUserRepository;
        this.mongoDBEmailRepository=mongoDBEmailRepository;
    }


    public List<Email> getMyInbox(String userID)
    {
        User me=mongoDBUserRepository.findOneBy_id(userID);
        String emailAddress=me.getEmail();

        return mongoDBEmailRepository.findAllBySendToEmailAddress(emailAddress);
    }

    public List<Email> getMySentEmails(String userID) {

        User me=mongoDBUserRepository.findOneBy_id(userID);
        String emailAddress=me.getEmail();

        return mongoDBEmailRepository.findAllBySentFromEmailAddress(emailAddress);
    }

    public User getMyEmailAddress(String userId) {
        return mongoDBUserRepository.findOneBy_id(userId);
    }

//    public User save(User user) {
//        return mongoDBUserRepository.save(user);
//    }
}
