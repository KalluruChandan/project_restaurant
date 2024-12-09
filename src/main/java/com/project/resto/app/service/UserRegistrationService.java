package com.project.resto.app.service;

import com.project.resto.app.model.request.RegistrationRequest;
import com.project.resto.app.model.response.RegistrationResponse;

public interface UserRegistrationService {
    RegistrationResponse signUpAnUser(RegistrationRequest registrationRequest);
}
