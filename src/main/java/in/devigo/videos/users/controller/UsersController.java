package in.devigo.videos.users.controller;

import in.devigo.videos.users.dto.ProfileAddRequest;
import in.devigo.videos.utils.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UsersController {


    @PostMapping(value = "/add",consumes = "multipart/form-data")
    public void addProfile( @Valid @ModelAttribute ProfileAddRequest request){

    }
}
