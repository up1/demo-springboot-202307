package com.example.day1.users;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserControllerFailureTest {

    @Autowired
    TestRestTemplate restTemplate;

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    public void initDataForTest() {
        userRepository.deleteAll();
        MyTable m1 = new MyTable(1, "demo", "Lname");
        userRepository.save(m1);
    }

    @AfterEach
    public void clearData() {
        userRepository.deleteAll();
    }

    @Test
    void createUser_with_duplicate_firstname() {
        // Send request to api
        CreateUserRequest request = new CreateUserRequest();
        request.setFirst_name("demo");
        request.setLast_name("Lname");
        ResponseEntity<MyError> result
                = restTemplate.postForEntity("/users", request, MyError.class);
        // Assert
        assertEquals(400, result.getStatusCode().value());
        assertEquals("24000", result.getBody().getCode());
        assertEquals("Firstname duplicated", result.getBody().getDescription());
    }
}