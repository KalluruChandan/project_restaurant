package com.project.resto.app.util;

import com.project.resto.app.model.response.ApiResponse;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

public class ApiResponseBuilder<T> {

    public static <T> ApiResponse<T> build(
            boolean success,
            String message,
            T data
    ) {
        return ApiResponse.<T>builder()
                .data(data)
                .message(message)
                .success(success)
                .timeStamp(LocalDateTime.now())
                .build();
    }

    public static <T> ApiResponse<T> build(
            boolean success,
            String message,
            T data,
            String errorCode
    ) {
        return ApiResponse.<T>builder()
                .data(data)
                .message(message)
                .success(success)
                .errorCode(errorCode)
                .timeStamp(LocalDateTime.now())
                .build();
    }
}
