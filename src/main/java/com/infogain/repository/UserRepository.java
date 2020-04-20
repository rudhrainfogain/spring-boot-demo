package com.infogain.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.infogain.dto.User;

@Repository
public class UserRepository
{

    Map<Integer,User> userDb=new HashMap<>();
    
    public int saveUser(User user) {
        userDb.put(user.getUserId(), user);
        return user.getUserId();
    }
    
    public User getUser(int userId) {
        return userDb.get(userId);
    }
}
