package com.connect_board.connect_board.advice;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
public class APIResponse<T>    {
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss z")
    private ZonedDateTime timestamp;
    private T data;
    private APIError error;

    public APIResponse(T data) {
        this();
        this.data = data;
    }

    public APIResponse() {
        this.timestamp = ZonedDateTime.now();

    }

    public APIResponse(APIError error) {
        this();
        this.error = error;
    }
}
