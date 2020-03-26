package com.ti.email.service;

import com.ti.email.model.Email;
import com.ti.email.model.User;
import com.ti.email.repository.MongoDBEmailRepository;
import com.ti.email.repository.MongoDBUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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


    public List<Email> getMyInbox(String userID) {
        User me=mongoDBUserRepository.findOneBy_id(userID);
        String emailAddress=me.getEmail();
        return mongoDBEmailRepository.findAllBySendToEmailAddress(emailAddress);
    }

//    public User save(User user) {
//        return mongoDBUserRepository.save(user);
//    }
}
