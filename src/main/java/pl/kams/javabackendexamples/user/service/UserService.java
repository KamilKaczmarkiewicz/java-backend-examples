package pl.kams.javabackendexamples.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kams.javabackendexamples.user.entity.User;
import pl.kams.javabackendexamples.user.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> find(String name) {
        return userRepository.findByName(name);
    }

    //@Transactional// co to jest?
    public void create(User user) {
        userRepository.save(user);
    }
}
