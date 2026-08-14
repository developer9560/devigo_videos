package in.devigo.videos.auth.dto;

import org.springframework.stereotype.Component;


public class SignupRequest {
    private String email;
    private String password;
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
