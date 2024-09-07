package com.liveasybackend.LiveasyBackend.service;


import com.liveasybackend.LiveasyBackend.dao.UserDetailsDao;
import com.liveasybackend.LiveasyBackend.model.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserDetailsService {
    @Autowired
    UserDetailsDao userDAO;
    public UserDetails createUser(UserDetails user) {
        return userDAO.save(user);
    }

    public UserDetails getUserDetails(String user_id) {
        return userDAO.findById(user_id).get();
    }

    public boolean deleteUser(String user_id) {
        try {
            userDAO.deleteById(user_id);
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean existsById(String userId){
        Optional<UserDetails> userDetails=userDAO.findById(userId);
        if (userDetails.isPresent()){
            return true;
        }
        return false;
    }
}
