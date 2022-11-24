package com.example.Auth.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.annotation.Resource;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "User already Exist")

public class UserAlreadyExistsException extends Exception {

}
