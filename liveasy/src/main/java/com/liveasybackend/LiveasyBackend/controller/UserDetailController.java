package com.liveasybackend.LiveasyBackend.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liveasybackend.LiveasyBackend.model.UserDetails;
import com.liveasybackend.LiveasyBackend.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserDetailController {


    @Autowired
    UserDetailsService userService;    public record  UserCreation(String user_Id, String message){};
    @PostMapping(path = "/createUser")
    public ResponseEntity<UserCreation> createUser(@RequestParam("user") String User) {

        UserDetails userDetails;
        ObjectMapper mapper = new ObjectMapper();
        try {
            userDetails = mapper.readValue(User, UserDetails.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        try {
            UserDetails newUser=userService.createUser(userDetails);
            return new ResponseEntity<>(new UserCreation(newUser.getUserDetails_Id(),"User Created Successfully "), HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new UserCreation(null,"Unable to Create User"),HttpStatus.EXPECTATION_FAILED);
    }


    @GetMapping("/getUser/{user_Id}")
    public ResponseEntity<UserDetails> getUser(@PathVariable String user_Id){
        try{
            return new ResponseEntity<>(userService.getUserDetails(user_Id),HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(null,HttpStatus.EXPECTATION_FAILED);
    }


    @DeleteMapping("/deleteUser/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable String userId){
        if(userService.deleteUser(userId)){
            return new ResponseEntity<>("user deleted successfully "+userId,HttpStatus.OK);
        }
        return new ResponseEntity<>("unable delete User "+userId,HttpStatus.EXPECTATION_FAILED);
    }

}
