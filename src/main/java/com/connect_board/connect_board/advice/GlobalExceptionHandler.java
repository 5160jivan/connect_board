package com.connect_board.connect_board.advice;

import com.connect_board.connect_board.exceptions.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<APIResponse<?>> handleResourceNotFoundException(ResourceNotFoundException ex) {

        APIError apiError = new APIError(HttpStatus.NOT_FOUND, ex.getMessage());
        log.error("Resource not found: {}", ex.getMessage());
        return new ResponseEntity<>(new APIResponse<>(apiError), apiError.getStatus());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<APIResponse<?>> handleIllegalArgumentException(IllegalArgumentException ex) {
        APIError apiError = new APIError(HttpStatus.BAD_REQUEST, ex.getMessage());
        log.error("Illegal argument: {}", ex.getMessage());
        return new ResponseEntity<>(new APIResponse<>(apiError), apiError.getStatus());
    }
}
