package com.ti.email.repository;

import com.ti.email.model.Email;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

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
        query.fields().exclude("_id").exclude("emailText");
        return operations.find(query,Email.class);
    }

    public Email getEmailBy_id(String emailId) {
        Query query=query(where("_id").is(emailId));
        return operations.findOne(query,Email.class);
    }
    @Override
    public Email sendEmail(Email email){
    return operations.save(email);
    }
}
