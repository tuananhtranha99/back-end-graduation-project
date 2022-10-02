package com.bezkoder.spring.datajpa.repository;

import com.bezkoder.spring.datajpa.entity.Role;
import com.bezkoder.spring.datajpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
