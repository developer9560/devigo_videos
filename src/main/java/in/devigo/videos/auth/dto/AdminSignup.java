package in.devigo.videos.auth.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class AdminSignup {
    @NotNull(message = "email cannot be null")
    @Email
    private String email;

    @NotNull(message = "password cannot be null")
    @Length(min = 6)
    private  String password;

    @NotNull(message = "confirm Password required")
    private String confirmPassword;

    public AdminSignup(String email, String password , String confirmPassword) {
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
