package com.example.day1.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCommandService {

    private UserRepository userRepository;

    @Autowired
    public UserCommandService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void process() {
        MyTable myTable = new MyTable(1, "f1", "f2");
        userRepository.save(myTable);
        userRepository.deleteAll();
    }

    public Integer createUser(CreateUserRequest newUser) {
        // 1. Check firstname duplicate ?
        List<MyTable> results = userRepository.findByFirstName(newUser.getFirst_name());
        if(results != null && results.size() > 0) {
            // Case 2 :: Firstname duplicated
            throw new DuplicateFirstnameException("xxxx yyyy");
        }
        // 2. Create new user
        MyTable myTable = new MyTable(1, newUser.getFirst_name(), newUser.getLast_name());
        userRepository.save(myTable);
        return myTable.getId();
    }


}
