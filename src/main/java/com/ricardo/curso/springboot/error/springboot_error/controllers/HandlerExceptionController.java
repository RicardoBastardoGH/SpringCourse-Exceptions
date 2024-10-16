package com.ricardo.curso.springboot.error.springboot_error.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.ricardo.curso.springboot.error.springboot_error.exceptions.UserNotFoundException;
import com.ricardo.curso.springboot.error.springboot_error.models.Error;


@RestControllerAdvice
public class HandlerExceptionController {

    @ExceptionHandler({ArithmeticException.class})
    public ResponseEntity<Error> divisionByZero(Exception ex) {
        Error error = new Error();
        error.setDate( new Date());
        error.setError("division por cero!");
        error.setMessage(ex.getMessage());
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        // return ResponseEntity.internalServerError().body(error);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(error);
    }

    @ExceptionHandler(NumberFormatException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> numberFormatException(Exception ex) {

        Map<String, Object> error = new HashMap<>();
        error.put("error", "no es un numero!");
        error.put("message", ex.getMessage());
        error.put("date", new Date().toString());
        error.put("status", String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));

        return error;
    }

    @ExceptionHandler({NullPointerException.class,
            HttpMessageNotWritableException.class,
            UserNotFoundException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> userNotFoundException(Exception ex) {

        Map<String, Object> error = new HashMap<>();
        error.put("error", "el usuario o rol no existe!");
        error.put("message", ex.getMessage());
        error.put("date", new Date().toString());
        error.put("status", String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));

        return error;
    }
    // public ResponseEntity<Error> notANumber(Exception ex) {
    //     Error error = new Error();
    //     error.setDate( new Date());
    //     error.setError("no es un numero!");
    //     error.setMessage(ex.getMessage());
    //     error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
    //     // return ResponseEntity.internalServerError().body(error);
    //     return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(error);
    // }

    // @ExceptionHandler(NullPointerException.class)

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<Error> notFound(NoHandlerFoundException ex) {
        Error error = new Error();
        error.setDate( new Date());
        error.setError("Api rest no encontrado!");
        error.setMessage(ex.getMessage());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(error);
        
    }

}
