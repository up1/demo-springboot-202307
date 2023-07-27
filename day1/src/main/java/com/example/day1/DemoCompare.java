package com.example.day1;

import com.example.day1.users.CreateUserRequest;

public class DemoCompare {
    public static void main(String[] args) {
        CreateUserRequest c1 = new CreateUserRequest();
        CreateUserRequest c2 = new CreateUserRequest();

        if(c1.equals(c2)) {
            System.out.println("Equal");
        } else {
            System.out.println("Not Equal");
        }
    }
}
