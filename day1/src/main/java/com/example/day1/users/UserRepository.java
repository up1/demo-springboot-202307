package com.example.day1.users;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<MyTable, Integer> {

    List<MyTable> findByFirstName(String firstName);

}
