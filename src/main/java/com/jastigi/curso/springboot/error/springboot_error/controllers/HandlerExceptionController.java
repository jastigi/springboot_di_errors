package com.jastigi.curso.springboot.error.springboot_error.controllers;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.jastigi.curso.springboot.error.springboot_error.models.Errors;

@RestControllerAdvice
public class HandlerExceptionController {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<Errors> divisionByZero(Exception ex) {

        Errors error = new Errors();
        error.setMessage(ex.getMessage());
        error.setError("Error división por cero!!");
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        error.setTimestamp(new Date());

        // return ResponseEntity.internalServerError().body(error);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);

    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<Errors> noHandlerFoundException(NoHandlerFoundException ex) {

        Errors error = new Errors();
        error.setMessage(ex.getMessage());
        error.setError("Api Rest no encontrada!!");
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setTimestamp(new Date());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);

    }

}
