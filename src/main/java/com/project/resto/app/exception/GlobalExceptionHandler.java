package com.project.resto.app.exception;

import com.project.resto.app.model.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ApiResponse<String>> inCaseOfMethodNotAllowedException(Exception e) {
        ApiResponse<String> apiResponse = ApiResponse.<String>builder()
                .success(false)
                .message(e.getMessage())
                .timeStamp(LocalDateTime.now())
                .errorCode(HttpStatus.METHOD_NOT_ALLOWED.toString())
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
    }
}
