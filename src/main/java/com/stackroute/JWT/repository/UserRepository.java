package com.stackroute.JWT.repository;


import com.stackroute.JWT.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserProfile, String> {
    UserProfile findByMailIdAndPassword(String mailId, String password);
    UserProfile findByMailId(String mailId);
    UserProfile findUserNameByMailId(String mailId);
}
