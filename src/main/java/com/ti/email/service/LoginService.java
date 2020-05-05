package com.ti.email.service;

import com.ti.email.model.Login;
import com.ti.email.model.User;
import com.ti.email.repository.MongoDBUserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class LoginService {
    private final MongoDBUserRepository mongoDBUserRepository;
    public LoginService(MongoDBUserRepository mongoDBUserRepository){
        this.mongoDBUserRepository=mongoDBUserRepository;
    }
    public String login(Login credentials) {
        User me=mongoDBUserRepository.login(credentials);
        if(null==me){
            throw new ResponseStatusException(
                    HttpStatus.FORBIDDEN, "Invalid username or password");
        }return me.get_id();
    }
}
