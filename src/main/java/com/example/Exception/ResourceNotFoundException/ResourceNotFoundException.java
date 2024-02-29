package com.example.Exception.ResourceNotFoundException;

public class ResourceNotFoundException extends RuntimeException {

    String user;
    Long id;
    public ResourceNotFoundException(String user, Long id) {
        super(String.format("%s not found with id : %s",user,id));
        this.user=user;
        this.id=id;

    }
}
