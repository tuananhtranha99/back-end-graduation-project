package com.bezkoder.spring.datajpa.service;

import com.bezkoder.spring.datajpa.entity.Color;
import com.bezkoder.spring.datajpa.entity.Product;

import java.util.List;

public interface ColorService {
    Color retrieve(Long id);
    List<Color> findAll();
}
