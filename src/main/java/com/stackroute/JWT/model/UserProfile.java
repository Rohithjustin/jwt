package com.stackroute.JWT.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class UserProfile {
    @Id
    String mailId;
    String password;
    String userName;
    String Url;


}
