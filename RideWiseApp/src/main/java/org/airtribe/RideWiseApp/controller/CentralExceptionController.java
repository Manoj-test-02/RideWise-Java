package org.airtribe.RideWiseApp.controller;

import org.airtribe.RideWiseApp.exception.DriverNotFoundException;
import org.airtribe.RideWiseApp.exception.DuplicateMailException;
import org.airtribe.RideWiseApp.exception.RiderNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CentralExceptionController {

    @ExceptionHandler(DuplicateMailException.class)
    public ResponseEntity handleDuplicateMailException(DuplicateMailException exception){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(exception.getMessage());
    }

    @ExceptionHandler(RiderNotFoundException.class)
    public ResponseEntity handleRiderNotFoundException(RiderNotFoundException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

    @ExceptionHandler(DriverNotFoundException.class)
    public ResponseEntity handleDriverNotFoundException(DriverNotFoundException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }
}
