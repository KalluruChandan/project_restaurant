package com.project.resto.app.exception;

import com.project.resto.app.model.response.ApiResponse;
import com.project.resto.app.util.ApiResponseBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    @ExceptionHandler(PasswordMissMatchException.class)
    public ResponseEntity<ApiResponse<Object>> inCaseOfPasswordMissMatchExceptionWhenRegistration(Exception e){
        ApiResponse<Object> apiResponse = ApiResponseBuilder.build(false,e.getMessage(),null, HttpStatus.BAD_REQUEST.toString());
        return new ResponseEntity<>(apiResponse,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ApiResponse<Object>> inCaseOfUserAlreadyExistsExceptionWhenRegistration(Exception e){
        ApiResponse<Object> apiResponse = ApiResponseBuilder.build(false,e.getMessage(),null, HttpStatus.BAD_REQUEST.toString());
        return new ResponseEntity<>(apiResponse,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiResponse<Object>> inCaseOfRuntimeExceptionWhenRegistration(Exception e){
        ApiResponse<Object> apiResponse = ApiResponseBuilder.build(false,e.getMessage(),null, HttpStatus.BAD_REQUEST.toString());
        return new ResponseEntity<>(apiResponse,HttpStatus.BAD_REQUEST);
    }
}
