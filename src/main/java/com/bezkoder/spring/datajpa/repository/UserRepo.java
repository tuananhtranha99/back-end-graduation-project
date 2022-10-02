package com.bezkoder.spring.datajpa.repository;

import com.bezkoder.spring.datajpa.entity.Brand;
import com.bezkoder.spring.datajpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByEmailAndPassword(String email, String password);
    User findByEmail(String email);
}
