package pl.kams.javabackendexamples.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.kams.javabackendexamples.user.entity.User;
import pl.kams.javabackendexamples.user.service.UserService;

import javax.annotation.PostConstruct;

@Component
public class InitializedData {

    private final UserService userService;

    @Autowired
    public InitializedData(UserService userService){
        this.userService = userService;
    }

    @PostConstruct
    private synchronized void init() {
        if(userService.find("admin").isEmpty()){
            User user1 = User.builder()
                    .name("admin")
                    .lastName("adminLastname")
                    .build();
            User user2 = User.builder()
                    .name("Bob")
                    .lastName("Kowalski")
                    .build();
            userService.create(user1);
            userService.create(user2);

        }
    }
}
