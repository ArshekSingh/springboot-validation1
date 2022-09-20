package net.javaguides.springbootvalidation.service;

import java.util.List;
import net.javaguides.springbootvalidation.model.User;

public interface ServiceInterface {
    User createUser(User user);
    List<User> getAllDetails();
    //User createUserFromRequest(User request)

}
