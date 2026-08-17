package in.devigo.videos.auth.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import org.springframework.stereotype.Component;


public class SignupRequest {
    @NotNull(message =  "Email cannot be null")
    @Email
    private String email;

    @NotNull(message = "Password is required")
    @Size(min = 6, max = 250, message = "Password must be greater than 6 character")
    private String password;

    @NotNull(message = " IsUser is required as true of false")
    private boolean isUser;

    public SignupRequest(String email, String password, boolean isUser) {
        this.email = email;
        this.password = password;
        this.isUser = isUser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isUser() {
        return isUser;
    }

    public void setUser(boolean user) {
        isUser = user;
    }
}
