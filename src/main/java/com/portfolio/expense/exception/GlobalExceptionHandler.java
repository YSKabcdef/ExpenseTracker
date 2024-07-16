package com.portfolio.expense.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import com.portfolio.expense.dto.ErrorDetails;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception,WebRequest webRequest){
        ErrorDetails details = new ErrorDetails(LocalDateTime.now(),exception.getMessage(),webRequest.getDescription(false),"RESOURCE_NOT_FOUND");
        return new ResponseEntity<>(details,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorDetails> handleGenericException(Exception exception,WebRequest webRequest){
        ErrorDetails details = new ErrorDetails(LocalDateTime.now(),exception.getMessage(),webRequest.getDescription(false),"INTERNAL SERVER ERROR");
        return new ResponseEntity<>(details,HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
