package com.bezkoder.spring.datajpa.service;

import com.bezkoder.spring.datajpa.entity.Brand;
import com.bezkoder.spring.datajpa.entity.Feature;

import java.util.List;

public interface FeatureService {
    void saveAll(List<Feature> list);
    void deleteByProductId(Long productId);
    void deleteProductTypeByProductId(Long productId);
}
