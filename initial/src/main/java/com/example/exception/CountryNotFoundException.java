package com.example.exception;

public class CountryNotFoundException extends RuntimeException {
    public CountryNotFoundException(String name) {
        super("Country " + name + " was not found!");
    }
}
