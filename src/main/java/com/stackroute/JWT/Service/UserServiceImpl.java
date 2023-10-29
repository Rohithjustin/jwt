package com.stackroute.JWT.Service;

import com.stackroute.JWT.Exception.registerAlreadyExists;
import com.stackroute.JWT.model.UserProfile;
import com.stackroute.JWT.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl  implements UserServiceDao {

    @Autowired
    UserRepository repository;


    //    @Override
//    public UserProfile registerUser(UserProfile user) {
//        return repository.save(user);
//    }
    @Override
    public UserProfile registerUser(UserProfile user) {
        UserProfile existingUser = repository.findByMailId(user.getMailId());
        if (existingUser != null) {
            throw new registerAlreadyExists("User with email " + user.getMailId() + " already exists");
        }
        return repository.save(user);
    }

    @Override
    public UserProfile getUserProfileByEmail(String emailId) {
        return repository.findByMailId(emailId);
    }
//

    @Override
    public boolean validateUser(UserProfile profile) {
        UserProfile user = repository.findByMailIdAndPassword(profile.getMailId(), profile.getPassword());
        if (user == null) {
            return false;
        } else {
            return true;
        }
    }

    public UserProfile getUrlByEmail(String emailId) {
        UserProfile url = repository.findByMailId(emailId);
        return repository.findByMailId( emailId);

    }
    @Override
    public UserProfile getUserNameByEmail(String email) {
        return  repository.findUserNameByMailId(email);
    }





}