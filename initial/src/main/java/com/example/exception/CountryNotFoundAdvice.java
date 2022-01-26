package com.example.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ControllerAdvice
public class CountryNotFoundAdvice {

    private ExceptionDTO exceptionDTO;

  @ResponseBody
  @ExceptionHandler(CountryNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  ExceptionDTO countryNotFoundHandler(CountryNotFoundException ex) {
    return new ExceptionDTO(HttpStatus.NOT_FOUND.value(), ex.getMessage());
  }
}
