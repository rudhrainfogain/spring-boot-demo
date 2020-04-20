package com.infogain.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.infogain.dto.User;
import com.infogain.dto.UserResponse;
import com.infogain.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController
{

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET, path = "/getuser", name = "/getuser")
    public ResponseEntity<User> getUser(@RequestParam(value = "userId") int userId)
    {

        return new ResponseEntity<User>(userService.getUser(userId), HttpStatus.OK);
    }

    @GetMapping(path = "/{userId}")
    public ResponseEntity<User> getUser1(@PathVariable(value = "userId") int userId)
    {

        return new ResponseEntity<User>(userService.getUser(userId), HttpStatus.OK);
    }

    @PostMapping( consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResponse> createUser(@RequestBody User user)
    {
        return new ResponseEntity<>(userService.processAndSaveUser(user), HttpStatus.CREATED);

    }
}
