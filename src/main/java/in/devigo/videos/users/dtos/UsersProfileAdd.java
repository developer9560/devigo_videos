package in.devigo.videos.users.dtos;

import in.devigo.videos.users.entity.Gender;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.multipart.MultipartFile;

public class UsersProfileAdd {
    @NotNull(message = "first name is required")
    private String firstName;

    private String lastName;

    @NotNull(message = "username is required")
    private String username;

//    private MultipartFile profilePicture;

    @NotNull(message = "only takes MALE ,FEMALE or OTHER")
    private Gender gender;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

//    public MultipartFile getProfilePicture() {
//        return profilePicture;
//    }
//
//    public void setProfilePicture(MultipartFile profilePicture) {
//        this.profilePicture = profilePicture;
//    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
