package com.bezkoder.spring.datajpa.service.service_impl;

import com.bezkoder.spring.datajpa.entity.Brand;
import com.bezkoder.spring.datajpa.entity.Product;
import com.bezkoder.spring.datajpa.repository.BrandRepo;
import com.bezkoder.spring.datajpa.repository.ProductRepo;
import com.bezkoder.spring.datajpa.service.BrandService;
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
public class BrandServiceImpl implements BrandService {

    private final BrandRepo brandRepo;


    @Override
    public List<Brand> findAll() {
        return brandRepo.findAll();
    }

    @Override
    public Brand retrieve(Long id) {
        return brandRepo.getById(id);
    }
}
