package com.bezkoder.spring.datajpa.controller;

import com.bezkoder.spring.datajpa.entity.Brand;
import com.bezkoder.spring.datajpa.entity.Color;
import com.bezkoder.spring.datajpa.service.BrandService;
import com.bezkoder.spring.datajpa.service.ColorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/color")
@RequiredArgsConstructor
public class ColorController {
    private final ColorService colorService;

    @GetMapping
    public ResponseEntity<List<Color>> getBrands(){
        return ResponseEntity.ok().body(colorService.findAll());
    }

}

