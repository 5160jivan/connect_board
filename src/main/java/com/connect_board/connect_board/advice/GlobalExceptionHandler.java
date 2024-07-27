package com.connect_board.connect_board.advice;

import com.connect_board.connect_board.exceptions.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    @ExceptionHandler(Exception.class)
    public ResponseEntity<APIResponse<?>> handleServerException(Exception ex) {
        APIError apiError = APIError.builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .message(ex.getMessage())
                .build();
        log.error("Internal server error: {}", ex.getMessage());
        return new ResponseEntity<>(new APIResponse<>(apiError), apiError.getStatus());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<APIResponse<?>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        List<String> errors = new ArrayList<>();
        for (ObjectError e : ex.getBindingResult().getAllErrors()) {
            String defaultMessage = e.getDefaultMessage();
            errors.add(defaultMessage);
        }
        APIError apiError = APIError.builder()
                .status(HttpStatus.BAD_REQUEST)
                .message("Validation failed: " + String.join(", ", errors))
                .build();
        return new ResponseEntity<>(new APIResponse<>(apiError), apiError.getStatus());
    }
}
