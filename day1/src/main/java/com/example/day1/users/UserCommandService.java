package com.example.day1.users;

import org.springframework.stereotype.Service;

@Service
public class UserCommandService {

    public Integer createUser(CreateUserRequest newUser) {
        // Case 1 :: Success
        if(!"demo".equals(newUser.getFirst_name())) {
            return 100;
        }
        // Case 2 :: Firstname duplicated
        throw new DuplicateFirstnameException("xxxx yyyy");
    }

}
