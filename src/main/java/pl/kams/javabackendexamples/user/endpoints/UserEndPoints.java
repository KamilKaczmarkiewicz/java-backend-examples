package pl.kams.javabackendexamples.user.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kams.javabackendexamples.user.entity.User;
import pl.kams.javabackendexamples.user.service.UserService;

import java.util.List;

@RestController
public class UserEndPoints {
    private UserService userService;

    @Autowired
    public UserEndPoints(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/test")
    public String get(){
        return "Działam!";
    }


    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.findAll();
    }

}
