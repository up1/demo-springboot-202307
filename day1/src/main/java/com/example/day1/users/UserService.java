package com.example.day1.users;

import org.springframework.stereotype.Service;

interface UserService {
    void create();
}

@Service
class UserServiceV1 implements  UserService {
    @Override
    public void create() {
        System.out.println("User service v1");
    }
}

@Service
class UserServiceV2 implements  UserService {
    @Override
    public void create() {
        System.out.println("User service v2");
    }
}


