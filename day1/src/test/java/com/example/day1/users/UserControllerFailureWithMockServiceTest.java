package com.example.day1.users;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserControllerFailureWithMockServiceTest {

    @Autowired
    TestRestTemplate restTemplate;

    @MockBean
    private UserCommandService service;

    @Test
    void createUser_with_duplicate_firstname() {
        CreateUserRequest request = new CreateUserRequest();
        request.setFirst_name("demo");
        request.setLast_name("Lname");
        // TODO
        when(service.createUser(request))
                .thenThrow(DuplicateFirstnameException.class);
        // Send request to api

        ResponseEntity<MyError> result
                = restTemplate.postForEntity("/users", request, MyError.class);
        // Assert
        assertEquals(400, result.getStatusCode().value());
        assertEquals("24000", result.getBody().getCode());
        assertEquals("Firstname duplicated", result.getBody().getDescription());
    }
}