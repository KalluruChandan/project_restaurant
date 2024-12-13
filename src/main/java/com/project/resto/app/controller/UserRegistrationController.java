package com.project.resto.app.controller;

import com.project.resto.app.model.request.RegistrationRequest;
import com.project.resto.app.model.response.ApiResponse;
import com.project.resto.app.model.response.RegistrationResponse;
import com.project.resto.app.service.UserRegistrationService;
import com.project.resto.app.util.ApiResponseBuilder;
import com.project.resto.app.util.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api")
@RequiredArgsConstructor
public class UserRegistrationController {

    private final UserRegistrationService userRegistrationService;

    @PostMapping("/registration/signup")
    public ResponseEntity<ApiResponse<RegistrationResponse>> signUpAnUser(
            @RequestBody RegistrationRequest registrationRequest
    ) {
        RegistrationResponse registrationResponse = userRegistrationService.signUpAnUser(registrationRequest);
        ApiResponse<RegistrationResponse> apiResponse = ApiResponseBuilder.build(true, Constants.SUCCESS, registrationResponse);
        return ResponseEntity.ok(apiResponse);
    }
}