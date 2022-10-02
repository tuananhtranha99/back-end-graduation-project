package com.bezkoder.spring.datajpa.service;

import com.bezkoder.spring.datajpa.entity.Brand;

import java.util.List;

public interface BrandService {
    List<Brand> findAll();
    Brand retrieve(Long id);
}
