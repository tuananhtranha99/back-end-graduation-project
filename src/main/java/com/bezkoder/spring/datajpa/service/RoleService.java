package com.bezkoder.spring.datajpa.service;

import com.bezkoder.spring.datajpa.entity.Role;
import com.bezkoder.spring.datajpa.entity.User;

public interface RoleService {
    Role findByName(String name);
}
