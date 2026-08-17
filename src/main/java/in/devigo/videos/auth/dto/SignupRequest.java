package in.devigo.videos.auth.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;


public class SignupRequest {
    @Email
    @NotNull(message = "email cannot be null")
    private String email;

    @NotNull(message = "password is required")
    @Length(min =6, max  =250)
    private String password;
    @NotNull(message = "only cantains TRUE , False")
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
