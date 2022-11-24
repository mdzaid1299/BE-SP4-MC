package com.example.Auth.service;

import com.example.Auth.domain.User;
import com.example.Auth.exception.UserAlreadyExistsException;
import com.example.Auth.exception.UserNotfoundException;
import com.example.Auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User addUser(User user) throws UserAlreadyExistsException {
        if (userRepository.findById(user.getUserId()).isPresent()) {
            throw new UserAlreadyExistsException();
        }
        return userRepository.save(user);
    }

    @Override
    public User findByUserIdAndPassword(String userId, String password) throws UserNotfoundException {
        User user = userRepository.findByUserIdAndPassword(userId, password);
        if (user == null) {
            throw new UserNotfoundException();
        }
        return user;
    }
}

