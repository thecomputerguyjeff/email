package com.ti.email.repository;

import com.ti.email.model.Email;

import org.springframework.data.repository.Repository;

import java.util.List;

public interface EmailRepository extends Repository<Email,String> {
    List<Email> findAllBySendToEmailAddress(String emailAddress);
    Email getEmailBy_id(String emailId);
    Email save(Email email);
    //List<Email> findAllSentByBy_id(String userId);


    }