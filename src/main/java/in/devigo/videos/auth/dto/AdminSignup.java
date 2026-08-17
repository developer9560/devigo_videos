package in.devigo.videos.auth.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.aspectj.bridge.Message;

public class AdminSignup {
    @NotNull(message = "Email cannot be null")
    @Email
    private String email;

    @NotNull(message =  "Password cannot be null")
    @Size(min = 6 ,max = 250 , message = "password size must be grater than 6 character")
    private  String password;

    @NotNull(message = "confirm Password cannot be null")
    @Size(min=6 , message = "password size must be greater than 6 character ")
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
