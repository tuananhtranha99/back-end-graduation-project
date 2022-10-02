package com.bezkoder.spring.datajpa.service.service_impl;

import com.bezkoder.spring.datajpa.entity.Brand;
import com.bezkoder.spring.datajpa.entity.User;
import com.bezkoder.spring.datajpa.repository.BrandRepo;
import com.bezkoder.spring.datajpa.repository.UserRepo;
import com.bezkoder.spring.datajpa.service.BrandService;
import com.bezkoder.spring.datajpa.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;


    @Override
    public User findByEmailAndPassword(String email, String password) {
        return userRepo.findByEmailAndPassword(email, password);
    }

    @Override
    public User findByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    @Override
    public User create(User user) {
        return userRepo.save(user);
    }
}
