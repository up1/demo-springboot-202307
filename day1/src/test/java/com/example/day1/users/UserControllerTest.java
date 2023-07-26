package com.example.day1.users;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserControllerTest {

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    void createUser_with_success() {
        CreateUserRequest request = new CreateUserRequest();
        request.setFirst_name("Fname");
        request.setLast_name("Lname");
        ResponseEntity<UserResponse> result
                = restTemplate.postForEntity("/users", request, UserResponse.class);
        // Assert
        assertEquals(200, result.getStatusCode().value());
        assertEquals("Fname", request.getFirst_name());
        assertEquals("Lname", request.getLast_name());
    }
}