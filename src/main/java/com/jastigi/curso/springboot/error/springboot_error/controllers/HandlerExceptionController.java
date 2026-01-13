package com.jastigi.curso.springboot.error.springboot_error.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.jastigi.curso.springboot.error.springboot_error.exceptions.UserNotFoudException;
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

    @ExceptionHandler(NumberFormatException.class)
    public Map<String, String> numberFormatException(NumberFormatException ex) {

        Map<String, String> error = new HashMap<>();
        error.put("message", ex.getMessage());
        error.put("error", "Número inválido o incorrecto, no tiene formato correcto!!");
        error.put("status", String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
        error.put("timestamp", new Date().toString());

        return error;

    }

    @ExceptionHandler({ NullPointerException.class,
            HttpMessageNotReadableException.class, UserNotFoudException.class })
    public Map<String, String> userNotFound(Exception ex) {

        Map<String, String> error = new HashMap<>();
        error.put("message", ex.getMessage());
        error.put("error", "El usuario o rol no existe!!");
        error.put("status", String.valueOf(HttpStatus.NOT_FOUND.value()));
        error.put("timestamp", new Date().toString());

        return error;

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
