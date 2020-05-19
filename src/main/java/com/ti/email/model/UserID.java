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
public class UserID {

    private String UserID;


    //This is the format of the emails
//    {
//        "UserID":"string",
//    }
}
