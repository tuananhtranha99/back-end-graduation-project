package com.bezkoder.spring.datajpa.controller;

import com.bezkoder.spring.datajpa.dto.*;
import com.bezkoder.spring.datajpa.entity.*;
import com.bezkoder.spring.datajpa.service.*;
import com.sun.xml.internal.ws.handler.HandlerException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/authenticate")
@RequiredArgsConstructor
public class AuthenticateController {
    private final UserService userService;
    private final RoleService roleService;

    @PostMapping("/login")
    public ResponseEntity<ResponseDTO> login(@RequestBody LoginDTO dto){
        ResponseDTO response = new ResponseDTO();
        User user = userService.findByEmailAndPassword(dto.getEmail(), dto.getPassword());
        if(user == null){
            // Không có tài khoản này
            response.setStatusCode(401);
        } else {
            response.setContent(user);
            response.setStatusCode(200);
        }
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/register")
    public ResponseEntity<ResponseDTO> register(@RequestBody LoginDTO dto){
        ResponseDTO response = new ResponseDTO();
        User user = userService.findByEmail(dto.getEmail());
        if(user == null){
            // Chưa có tài khoản này
            user = new User();
            user.setName(dto.getUsername());
            user.setEmail(dto.getEmail());
            user.setPassword(dto.getPassword());
            user.setRole(roleService.findByName("ROLE_USER"));
            user = userService.create(user);
            response.setContent(user);
            response.setStatusCode(200);
        } else {
            response.setStatusCode(409);
        }
        return ResponseEntity.ok().body(response);
    }

}

