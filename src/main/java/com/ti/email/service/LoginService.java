package com.ti.email.service;

import com.ti.email.model.Login;
import com.ti.email.model.User;
import com.ti.email.repository.MongoDBUserRepository;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private final MongoDBUserRepository mongoDBUserRepository;
    public LoginService(MongoDBUserRepository mongoDBUserRepository){
        this.mongoDBUserRepository=mongoDBUserRepository;
    }
    public String login(Login credentials) {
        User me=mongoDBUserRepository.login(credentials);
        if(null==me){
            return null;
        }return me.get_id();
    }
}
