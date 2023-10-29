package com.stackroute.JWT.Service;


import com.stackroute.JWT.model.UserProfile;

public interface UserServiceDao {
    UserProfile registerUser(UserProfile user);
    boolean validateUser(UserProfile profile);
     UserProfile getUserProfileByEmail(String email);
    UserProfile getUrlByEmail(String email);
    UserProfile getUserNameByEmail(String email);
}
