package com.ti.email.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "email")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Email {
    @Id
    private String _id;
    @NotNull(message = "Send to email address is required")
    private List<String> sendToEmailAddress;
    @NotNull(message = "Sent from email address is required")
    private String sentFromEmailAddress;
    @NotNull(message = "Subject is required")
    private String subject;
    @NotNull(message = "Email text is required")
    private String emailText;

    //This is the format of the emails
//    {
//        "sendToEmailAddress":["string","string"],
//        "sentFromEmailAddress":"string",
//        "subject":"string",
//        "emailText":"string"
//    }
}
