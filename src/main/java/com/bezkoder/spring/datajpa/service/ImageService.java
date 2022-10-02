package com.bezkoder.spring.datajpa.service;

import com.bezkoder.spring.datajpa.entity.Feature;
import com.bezkoder.spring.datajpa.entity.Image;

import java.util.List;

public interface ImageService {
    void saveAll(List<Image> list);
    void deleteByProductId(Long productId);
}
