package com.ti.email.repository;

import com.ti.email.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

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

//    public User save(User user) {
//        return operations.save(user);
//    }
}
