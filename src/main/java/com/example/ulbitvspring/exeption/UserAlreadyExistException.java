package com.example.ulbitvspring.exeption;

public class UserAlreadyExistException  extends Exception{
    public UserAlreadyExistException(String message) {
        super(message);
    }
}
