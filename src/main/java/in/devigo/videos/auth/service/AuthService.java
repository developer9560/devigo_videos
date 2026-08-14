package in.devigo.videos.auth.service;

import in.devigo.videos.auth.dto.AdminSignup;
import in.devigo.videos.auth.dto.LoginRequest;
import in.devigo.videos.auth.dto.LoginResponse;
import in.devigo.videos.auth.dto.SignupRequest;
import in.devigo.videos.auth.entity.Auth;
import in.devigo.videos.auth.entity.Roles;
import in.devigo.videos.auth.repository.AuthRepository;
import in.devigo.videos.exception.AuthenticationException;
import in.devigo.videos.security.JwtUtil;
import in.devigo.videos.utils.ApiResponse;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final AuthRepository repository;

    AuthService(AuthRepository repository){
        this.repository = repository;
    }

    public ApiResponse<String> userSignup(SignupRequest request){
        if(repository.findByEmail(request.getEmail()).isPresent()){
            return new ApiResponse<>(400,"email already found");
        }

        Auth auth = new Auth();
        auth.setEmail(request.getEmail());
        auth.setPassword(request.getPassword());
        if(request.isUser()){
            auth.setRole(Roles.USERS);
        }else{
            auth.setRole(Roles.CREATOR);
        }
        repository.save(auth);
        return new ApiResponse<>(200, "User Register SuccessFully");

    }
    public ApiResponse<String> adminSignup(AdminSignup request){
        if(repository.findByEmail(request.getEmail()).isPresent()){
            return new ApiResponse<>(400,"email already found");
        }

        Auth auth = new Auth();
        auth.setEmail(request.getEmail());
        auth.setPassword(request.getPassword());
        auth.setRole(Roles.ADMIN);
        repository.save(auth);
        return new ApiResponse<>(200, "Admin Register SuccessFully");
    }

    public LoginResponse userLogin(LoginRequest request){
        Auth auth = repository.findByEmail(request.getEmail()).orElseThrow(()-> new AuthenticationException("Invalid email or Password"));
        if(auth.getRole()==Roles.ADMIN){
            throw new AuthenticationException("Invalid Email");
        }
        if(!auth.getPassword().equals(request.getPassword())){
            throw new AuthenticationException("Invalid Email or Password");
        }
        JwtUtil jwt = new JwtUtil();
        String token ="";
        if(auth.getRole()==Roles.USERS){
            token += jwt.generateTokenForUser(auth.getId(),Roles.USERS.name());
        }else{
            token += jwt.generateTokenForUser(auth.getId(),Roles.CREATOR.name());
        }


         return  new LoginResponse(auth.getEmail(),token);

    }

    public LoginResponse adminLogin(LoginRequest request){
        Auth auth = repository.findByEmail(request.getEmail()).orElseThrow(()->
                new AuthenticationException("Invalid email or Password"));
        if(auth.getRole()!=Roles.ADMIN){
            throw new AuthenticationException("Invalid email or passowrd");
        }

        if(!auth.getPassword().equals(request.getPassword())){
            throw  new AuthenticationException("Invalid Email or Password");
        }
        JwtUtil jwt = new JwtUtil();
        String token = jwt.generateToken(auth.getId(),Roles.ADMIN.name());
        return new LoginResponse(auth.getEmail(), token);
    }



}
