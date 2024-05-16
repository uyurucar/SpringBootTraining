package com.ucaru.restdemo.restdemo.rest;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {

    //add exception handling code
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc)
    {
        // create a response
        StudentErrorResponse errorResponse = new StudentErrorResponse();
        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponse.setMessage(exc.getMessage());
        errorResponse.setTimeStamp(System.currentTimeMillis());
        //return responseEntity
        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }

    //add a generic exception handler
    @ExceptionHandler
    ResponseEntity<StudentErrorResponse> handleException(Exception exc)
    {
        // create a response
        StudentErrorResponse errorResponse = new StudentErrorResponse();
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponse.setMessage(exc.getMessage());
        errorResponse.setTimeStamp(System.currentTimeMillis());
        //return responseEntity
        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);

    }

}
