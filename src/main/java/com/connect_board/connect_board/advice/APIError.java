package com.connect_board.connect_board.advice;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;
@Getter
@Setter
public class APIError {
    private HttpStatus status;
    private String message;

    public APIError(HttpStatus status, String error) {
        this.status = status;
        this.message = error;
    }

}