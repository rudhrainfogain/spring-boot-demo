package com.infogain.exceptions.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.infogain.controllers.UserController;
import com.infogain.exceptions.UserException;

@ControllerAdvice(basePackageClasses = UserController.class)
public class UserControllerAdvice
{

    @ExceptionHandler(value = UserException.class)
    public ResponseEntity<Map<String, String>> handleUserException(UserException ex){
        Map<String,String> response= new HashMap<String, String>();
        response.put("message", ex.getMessage());
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        
    }
}
