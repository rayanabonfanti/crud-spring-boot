package com.crud.h2console.exceptions;

public class DataNotFoundException extends RuntimeException {

    public DataNotFoundException (String message){
        super(message);
    }
}
