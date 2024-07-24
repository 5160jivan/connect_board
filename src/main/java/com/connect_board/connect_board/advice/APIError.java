package com.connect_board.connect_board.advice;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;
@Getter
@Setter
public class APIError {
    private LocalDate timestamp;
    private HttpStatus status;
    private String error;

    public APIError(HttpStatus status, String error) {
        this();
        this.status = status;
        this.error = error;
    }

    public APIError() {
        this.timestamp = LocalDate.now();
    }


}