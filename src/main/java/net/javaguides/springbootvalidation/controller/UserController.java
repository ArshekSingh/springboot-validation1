package net.javaguides.springbootvalidation.controller;

import javax.validation.Valid;

import net.javaguides.springbootvalidation.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import net.javaguides.springbootvalidation.model.User;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private ServiceInterface serviceInterface;

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        User savedUser = serviceInterface.createUser(user);
        return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("details")
    public List<User> getAllDetails(){
        return serviceInterface.getAllDetails();
    }
}
