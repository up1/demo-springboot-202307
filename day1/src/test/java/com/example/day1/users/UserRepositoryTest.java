package com.example.day1.users;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void checkFirstName_duplicated() {
        // Prepare user ::
        MyTable m1 = new MyTable(1, "f1", "l1");
        MyTable m2 = new MyTable(2, "f2", "l2");
        userRepository.save(m1);
        userRepository.save(m2);
        // Check firstname
        List<MyTable> results = userRepository.findByFirstName("f1");
        // Check result
        assertEquals(1, results.size());
        assertEquals("f1", results.get(0).getFirstName());
    }
}