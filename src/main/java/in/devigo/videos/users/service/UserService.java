package in.devigo.videos.users.service;

import in.devigo.videos.exception.AuthenticationException;
import in.devigo.videos.exception.BadRequestException;
import in.devigo.videos.security.JwtUtil;
import in.devigo.videos.users.dtos.UsersProfileAdd;
import in.devigo.videos.users.entity.User;
import in.devigo.videos.users.repository.UserRepository;
import in.devigo.videos.utils.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository repository;
    private final JwtUtil jwtUtil;

    @Autowired
    public UserService(UserRepository repository, JwtUtil jwtUtil) {
        this.repository = repository;
        this.jwtUtil = jwtUtil;
    }

     public String createUser(UsersProfileAdd profile, Long authId){
        if(repository.existsByUserName(profile.getUsername())){
            throw new BadRequestException("Username is already in use");
        }
        User user = new User();
        user.setUserName(profile.getUsername());
        user.setFirstName(profile.getFirstName());
        user.setLastName(profile.getLastName());
        user.setGender(profile.getGender());
        repository.save(user);
        return "User is created successfully";

    }
}
