package com.ti.email.repository;

import com.ti.email.model.Email;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Repository
public class MongoDBEmailRepository implements EmailRepository{

    private final MongoOperations operations;
    public MongoDBEmailRepository(MongoOperations operations){
        this.operations=operations;
    }

    @Override
    public List<Email> findAllBySendToEmailAddress(String emailAddress ) {
        Query query=query(where("sendToEmailAddress").is(emailAddress));
        if (query.equals(null)){
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "entity not found"
        );}
        query.fields().exclude("emailText").exclude("sendToEmailAddress");
        return operations.find(query,Email.class);
    }


    public Email getEmailBy_id(String emailId) {
        Query query=query(where("_id").is(emailId));
        return operations.findOne(query,Email.class);
    }

    @Override
    public Email save(Email email) {
        return operations.save(email);
    }




}



