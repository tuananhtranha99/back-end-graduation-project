package com.bezkoder.spring.datajpa.service.service_impl;

import com.bezkoder.spring.datajpa.entity.Role;
import com.bezkoder.spring.datajpa.entity.User;
import com.bezkoder.spring.datajpa.repository.RoleRepo;
import com.bezkoder.spring.datajpa.repository.UserRepo;
import com.bezkoder.spring.datajpa.service.RoleService;
import com.bezkoder.spring.datajpa.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class RoleServiceImpl implements RoleService {

    private final RoleRepo roleRepo;


    @Override
    public Role findByName(String name) {
        return roleRepo.findByName(name);
    }
}
