package com.qa.demo.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Book does not exist with that ID")
public class UserNotFoundException extends EntityNotFoundException{
    public UserNotFoundException() {
		super();
		
	}
    public UserNotFoundException(String message){
        super(message);
    }
}
