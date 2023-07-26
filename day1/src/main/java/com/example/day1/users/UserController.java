package com.example.day1.users;

import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @GetMapping("/users/{id}")
    public UserResponse getUserById(@PathVariable String id) {
        return new UserResponse();
    }

    @GetMapping("/users")
    public UserResponse getUserById2(@RequestParam String id) {
        return new UserResponse();
    }

    @PostMapping("/users")
    public UserResponse createUser(@RequestBody CreateUserRequest user){
        System.out.println(user.getFirst_name());
        System.out.println(user.getLast_name());
        return new UserResponse();
    }



}
