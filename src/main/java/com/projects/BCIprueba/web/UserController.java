package com.projects.BCIprueba.web;

import com.projects.BCIprueba.data.payloads.request.UserRequest;
import com.projects.BCIprueba.data.payloads.response.UserResponse;
import com.projects.BCIprueba.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> addUser(@RequestBody UserRequest user){
        UserResponse newUser = userService.createUser(user);

        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

}
