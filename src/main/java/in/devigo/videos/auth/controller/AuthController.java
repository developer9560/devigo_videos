package in.devigo.videos.auth.controller;

import in.devigo.videos.auth.dto.AdminSignup;
import in.devigo.videos.auth.dto.LoginRequest;
import in.devigo.videos.auth.dto.LoginResponse;
import in.devigo.videos.auth.dto.SignupRequest;
import in.devigo.videos.auth.service.AuthService;
import in.devigo.videos.utils.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth/")
public class AuthController {

    private final AuthService service;

    public AuthController(AuthService service){
        this.service = service;
    }

    @PostMapping("/users/signup")
    public ResponseEntity<ApiResponse<String>> userSignup(@RequestBody @Valid SignupRequest request){
       return ResponseEntity.ok(service.userSignup(request));
    }

    @PostMapping("/admin/signup")
    public ResponseEntity<ApiResponse<String>> adminLogin(@RequestBody @Valid AdminSignup request ){
        return ResponseEntity.ok(service.adminSignup(request));
    }

    @PostMapping("users/login")
    public ResponseEntity<ApiResponse<LoginResponse>> userLogin(@RequestBody @Valid LoginRequest request){
        LoginResponse loginResponse = service.userLogin(request);
        return ResponseEntity.ok(new ApiResponse<>(200,"login Successfull",loginResponse));
    }

    @PostMapping("/admin/login")
    public ResponseEntity<ApiResponse<LoginResponse>> adminLogin(@RequestBody @Valid LoginRequest request){
        LoginResponse response = service.adminLogin(request);
        return ResponseEntity.ok(new ApiResponse<>(200,"login Successfull",response));
    }

}
