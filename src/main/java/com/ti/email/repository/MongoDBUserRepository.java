package com.ti.email.repository;

import com.ti.email.model.Email;
import com.ti.email.model.Login;
import com.ti.email.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Repository
public class MongoDBUserRepository implements UserRepository{

    private final MongoOperations operations;

    public MongoDBUserRepository(MongoOperations operations) {
        this.operations = operations;
    }

    @Override
    public User findOneBy_id(String id){
        Query query2 = new Query();
        query2.addCriteria(Criteria.where("_id").is("ObjectId("+id+")"));
        Query query=query(where("_id").is(id));

        return operations.findOne(query,User.class);
    }

    public User login(Login credentials) {
        if(credentials.getUsername()==null||credentials.getPassword()==null){
            return null;
        }
        Query query=query(where("username").is(credentials.getUsername()));
        query.addCriteria(where("password").is(credentials.getPassword()));
        query.fields().exclude("name").exclude("email").exclude("username").exclude("password").exclude("role");
        User me;
        try {
            me= operations.findOne(query, User.class);
        }catch(Exception e){
            return null;
        }
        return me;
    }

//    public User save(User user) {
//        return operations.save(user);
//    }
}
