package com.ti.email.repository;

import com.ti.email.model.User;
import org.springframework.data.repository.Repository;



public interface UserRepository extends Repository<User,String> {
    User findOneBy_id(String id);
//    User save(User user);
}
