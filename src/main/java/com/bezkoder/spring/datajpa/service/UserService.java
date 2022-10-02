package com.bezkoder.spring.datajpa.service;

import com.bezkoder.spring.datajpa.dto.ProductInOrderDTO;
import com.bezkoder.spring.datajpa.entity.Product;
import com.bezkoder.spring.datajpa.entity.User;

import java.util.List;

public interface UserService {
    User findByEmailAndPassword(String email, String password);
    User findByEmail(String email);
    User create(User user);
}
