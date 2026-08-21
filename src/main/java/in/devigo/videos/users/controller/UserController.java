package in.devigo.videos.users.controller;

import in.devigo.videos.exception.UnauthorizedException;
import in.devigo.videos.users.dtos.UsersProfileAdd;
import in.devigo.videos.users.service.UserService;
import in.devigo.videos.utils.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse<String>> createUser(@RequestBody UsersProfileAdd profile , Authentication authentication){
        if(authentication==null || !authentication.isAuthenticated()){
            throw new UnauthorizedException("Please login first");
        }
        Long userId =(Long) authentication.getPrincipal();
        String message =  userService.createUser(profile,userId);
        return ResponseEntity.ok(new ApiResponse<>(201,message));
    }

//    @GetMapping("/get")
//    public List<UsersProfileAdd> getAllUser(@RequestHeader("Authorization") String token){
//        userService.getAllUser();
//        return
//    }
//
//    @GetMapping("/getUser/{id}")
//    public ResponseEntity<UsersProfileAdd> getUesrById(@RequestParam long id){
//        userService.getUserById(id);
//        return ResponseEntity.ok(new UsersProfileAdd());
//    }
}
