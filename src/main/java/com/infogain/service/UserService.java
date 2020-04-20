package com.infogain.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infogain.dto.User;
import com.infogain.dto.UserResponse;
import com.infogain.exceptions.UserException;
import com.infogain.repository.UserRepository;

@Service
public class UserService
{
    Random r= new Random();
    
    @Autowired
    UserRepository userRepository;
    
    public UserResponse processAndSaveUser(User user) {
      user.setUserId(r.nextInt());
    userRepository.saveUser(user);
    UserResponse response= new UserResponse(user);
    Map<String,String> endpoints= new HashMap<String, String>();
    endpoints.put("getUser","/user/{userId}");
    response.generateLinks(endpoints);
    return response;
        
    }
    
    public User getUser(int userId) {
        if(userId!=0) {
            return userRepository.getUser(userId);
        }
        else {
            throw new UserException("Invalid user Id");
        }
    }
}
