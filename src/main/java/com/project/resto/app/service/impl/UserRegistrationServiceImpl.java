package com.project.resto.app.service.impl;

import com.project.resto.app.entity.User;
import com.project.resto.app.exception.UserAlreadyExistsException;
import com.project.resto.app.model.request.RegistrationRequest;
import com.project.resto.app.model.response.RegistrationResponse;
import com.project.resto.app.repository.UserRegistrationRepository;
import com.project.resto.app.service.UserRegistrationService;
import com.project.resto.app.exception.PasswordMissMatchException;
import com.project.resto.app.util.Constants;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserRegistrationServiceImpl implements UserRegistrationService{

    private final UserRegistrationRepository userRegistrationRepository;

    private final ModelMapper modelMapper;

    @Override
    public RegistrationResponse signUpAnUser(RegistrationRequest registrationRequest) {
        //if password and confirm password are matched
        if(registrationRequest != null && registrationRequest.getPassword().equals(registrationRequest.getConfirmPassword())){

            //if requested email already exists
            Optional<User> userFoundOpt = userRegistrationRepository.findByEmail(registrationRequest.getEmail());
            if(userFoundOpt.isPresent()){
                throw new UserAlreadyExistsException("Email already registered");
            }else {
                try{
                    User userToRegister = modelMapper.map(registrationRequest, User.class);
                    User savedUser = userRegistrationRepository.save(userToRegister);
                    return RegistrationResponse.builder()
                            .message(Constants.USER_CREATED)
                            .response(savedUser)
                            .build();
                }catch (Exception e){
                    throw new RuntimeException("Exception while saving user in database " + e.getMessage());
                }
            }
        }else {
            throw new PasswordMissMatchException("Please provide matching passwords");
        }
    }
}