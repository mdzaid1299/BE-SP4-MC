package com.example.Auth.service;

import com.example.Auth.domain.User;
import com.example.Auth.exception.UserAlreadyExistsException;
import com.example.Auth.exception.UserNotfoundException;

public interface UserService {
    User addUser(User user) throws UserAlreadyExistsException;
    User findByUserIdAndPassword(String userId,String password) throws UserNotfoundException;
}
