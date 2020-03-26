package com.ti.email.repository;

import com.ti.email.model.Email;
import com.ti.email.model.User;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface EmailRepository extends Repository<Email,String> {
    @Query(value="{}", fields="{sendToEmailAddress : 1,sentFromEmailAddress:1,subject:1,emailText:0, _id : 0}")
    List<Email> findAllBySendToEmailAddress(String emailAddress);
}
