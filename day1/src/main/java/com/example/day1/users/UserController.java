package com.example.day1.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userServiceV1;


    @GetMapping("/users/{id}")
    public UserResponse getUserById(@PathVariable String id) {
        userCommandService.process();
        return new UserResponse();
    }

    @GetMapping("/users")
    public UserResponse getUserById2(@RequestParam String id) {
        return new UserResponse();
    }

    @Autowired
    private UserCommandService userCommandService;

    @PostMapping("/users")
    public ResponseEntity<UserResponse> createUser(@RequestBody CreateUserRequest user){
        // 1. Get data from request body
        // 2. Validate input
        // 3. call service layer
        Integer id = userCommandService.createUser(user);
        // 4. Return response to caller
        UserResponse userResponse = new UserResponse();
        userResponse.setId(id);
        userResponse.setFirst_name(user.getFirst_name());
        userResponse.setLast_name(user.getLast_name());

        // Return with success code = 201
        return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
    }



}
