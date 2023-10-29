package com.stackroute.JWT.controller;

import com.stackroute.JWT.Service.UserServiceImpl;
import com.stackroute.JWT.model.UserProfile;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")

public class UserController {

    @Autowired
    UserServiceImpl service ;


    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserProfile profile){
        return new ResponseEntity<UserProfile>(service.registerUser(profile), HttpStatus.CREATED);
    }

    @PostMapping("login")
    public ResponseEntity<?> loginUser(@RequestBody UserProfile profile){
        boolean result = service.validateUser(profile);

        if(result){
            String token = generateToken(profile);
//            HashMap hashMap = new HashMap();
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("token",token);
            hashMap.put("email", profile.getMailId());


            return  new ResponseEntity<HashMap>(hashMap,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<String>("Invalid Credentails",HttpStatus.UNAUTHORIZED);
        }
    }
//    @GetMapping("/username/{emailId}")
//    public ResponseEntity<?> getUsernameByEmailId(@PathVariable String emailId){
//        UserProfile userProfile = service.getUserProfileByEmail(emailId);
//
//        if(userProfile != null){
//            return new ResponseEntity<>(userProfile.getUserName(), HttpStatus.OK);
//        }
//        else{
//            return new ResponseEntity<String>("User not found", HttpStatus.NOT_FOUND);
//        }
//    }


    @GetMapping("/username/{emailId}")
    public ResponseEntity<?> getUsernameByEmailId(@PathVariable String emailId){
        UserProfile  profile = service.getUserNameByEmail(emailId);
        return  new ResponseEntity<>(profile,HttpStatus.OK);
    }

    @GetMapping("/url/{emailId}")
    public ResponseEntity<?> getUrlByEmailId(@PathVariable String emailId) {
        UserProfile url = service.getUrlByEmail(emailId);

        if ( url.getUrl() != null) {
            return new ResponseEntity<String>(url.getUrl(), HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("URL not found", HttpStatus.NOT_FOUND);
        }
    }


    private String generateToken(UserProfile profile){
        return Jwts.builder().setSubject(profile.getUserName())
                .setAudience(profile.getMailId())
                .setAudience("rohith")
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+ 300000))
                .signWith(SignatureAlgorithm.HS256,"music").compact();
    }




}
