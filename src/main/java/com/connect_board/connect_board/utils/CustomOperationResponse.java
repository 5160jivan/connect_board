package com.connect_board.connect_board.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomOperationResponse implements Serializable {

    private String message;
    private boolean success;

    public CustomOperationResponse(String message) {
        this.message = message;
    }

    public CustomOperationResponse(boolean success) {
        this.success = success;
    }

    public CustomOperationResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

}
