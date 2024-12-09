package com.project.resto.app.model.response;

import com.project.resto.app.entity.User;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegistrationResponse {

    private String message;
    private User response;
}
