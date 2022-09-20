package net.javaguides.springbootvalidation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import net.javaguides.springbootvalidation.model.User;
import net.javaguides.springbootvalidation.repository.UserRepository;

import java.util.List;

@Service

public class UserService implements ServiceInterface {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    //This method use to save all details when controller send request of PostMapping
    public User createUser(User request) {
        try {
            User user = createUserFromRequest(request);
            return userRepository.save(user);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private User createUserFromRequest(User request) {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setName(request.getName());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        return user;
    }


    //This method use to get all details when controller send request of GetMapping
    public List<User> getAllDetails() {
        return (List<User>) userRepository.findAll();
    }

}
