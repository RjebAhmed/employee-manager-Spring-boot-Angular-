package com.employeemanager.manager.services;

public class userNotFoundException extends RuntimeException{
    public userNotFoundException(String message) {
        super(message);
    }
}
