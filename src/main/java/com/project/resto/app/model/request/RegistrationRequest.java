package com.project.resto.app.model.request;

import com.project.resto.app.util.Constants;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegistrationRequest {

    @NotBlank(message = "First name is required")
    @Size(max = 50, message = "First name cannot exceed 50 characters")
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Size(max = 50, message = "Last name cannot exceed 50 characters")
    private String lastName;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    @Size(max = 100, message = "Email cannot exceed 100 characters")
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 8, max = 20, message = "Password must be between 8 and 20 characters")
    @Pattern(
            regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$",
            message = "Password must contain at least one digit, one lowercase, one uppercase letter, and one special character"
    )
    private String password;

    @NotBlank(message = "Confirm Password is required")
    private String confirmPassword;

    @NotNull(message = "Phone number is required")
    @Pattern(
            regexp = "^[1-9][0-9]{9}$",
            message = "Invalid phone number format"
    )
    private String phoneNumber;

    @NotNull(message = "Date of birth is required")
    private String dateOfBirth; // Use ISO format (yyyy-MM-dd)

    @NotBlank(message = "Address is required")
    @Size(max = 200, message = "Address cannot exceed 200 characters")
    private String address;

    @Override
    public String toString() {
        return "RegistrationRequest{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + Constants.PII_MASK + '\'' +
                ", password='" + Constants.PII_MASK + '\'' +
                ", confirmPassword='" + Constants.PII_MASK + '\'' +
                ", phoneNumber='" + Constants.PII_MASK + '\'' +
                ", dateOfBirth='" + Constants.PII_MASK + '\'' +
                ", address='" + Constants.PII_MASK + '\'' +
                '}';
    }
}