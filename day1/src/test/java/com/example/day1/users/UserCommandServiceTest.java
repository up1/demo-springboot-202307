package com.example.day1.users;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserCommandServiceTest {

    @Mock
    private UserRepository userRepository;

    @Test
    void createUser_success() {
        CreateUserRequest request = new CreateUserRequest();
        request.setFirst_name("Fname");
        request.setLast_name("Lname");
        UserCommandService service = new UserCommandService(userRepository);
        Integer id = service.createUser(request);
        assertEquals(1, id);
    }

    @Test
    void createUser_failure_duplicate_firstname() {
    }
}