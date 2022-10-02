package com.bezkoder.spring.datajpa.service.service_impl;

import com.bezkoder.spring.datajpa.entity.Color;
import com.bezkoder.spring.datajpa.entity.Product;
import com.bezkoder.spring.datajpa.repository.ColorRepo;
import com.bezkoder.spring.datajpa.repository.ProductRepo;
import com.bezkoder.spring.datajpa.service.ColorService;
import com.bezkoder.spring.datajpa.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ColorServiceImpl implements ColorService {

    private final ColorRepo colorRepo;


    @Override
    public Color retrieve(Long id) {
        return colorRepo.findById(id).get();
    }

    @Override
    public List<Color> findAll() {
        return colorRepo.findAll();
    }
}
