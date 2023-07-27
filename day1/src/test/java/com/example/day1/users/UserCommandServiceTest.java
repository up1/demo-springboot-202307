package com.example.day1.users;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

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
        CreateUserRequest request = new CreateUserRequest();
        request.setFirst_name("demo");
        request.setLast_name("Lname");

        List<MyTable> results = new ArrayList<>();
        results.add(new MyTable());
        when(userRepository.findByFirstName("demo")).thenReturn(results);

        UserCommandService service = new UserCommandService(userRepository);
        Exception exception = assertThrows(
                DuplicateFirstnameException.class, () -> {
                    service.createUser(request);
                });
        assertEquals("xxxx yyyy", exception.getMessage());
    }

    @Test
    void createUser_failure_duplicate_firstname_with_spy(){
        CreateUserRequest request = new CreateUserRequest();
        request.setFirst_name("demo");
        request.setLast_name("Lname");

        List<MyTable> results = new ArrayList<>();
        results.add(new MyTable());
        when(userRepository.findByFirstName("demo")).thenReturn(results);

        UserCommandService service = new UserCommandService(userRepository);
        try {
            service.createUser(request);
        }catch (Exception e) {}
        // Assert
        verify(userRepository, times(1)).findByFirstName("demo");
    }
}