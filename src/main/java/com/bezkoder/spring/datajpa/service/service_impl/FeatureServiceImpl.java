package com.bezkoder.spring.datajpa.service.service_impl;

import com.bezkoder.spring.datajpa.entity.Brand;
import com.bezkoder.spring.datajpa.entity.Feature;
import com.bezkoder.spring.datajpa.repository.BrandRepo;
import com.bezkoder.spring.datajpa.repository.FeatureRepo;
import com.bezkoder.spring.datajpa.service.BrandService;
import com.bezkoder.spring.datajpa.service.FeatureService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class FeatureServiceImpl implements FeatureService {

    private final FeatureRepo featureRepo;


    @Override
    public void saveAll(List<Feature> list) {
        featureRepo.saveAll(list);
    }

    @Override
    public void deleteByProductId(Long productId) {
        featureRepo.deleteByProductId(productId);
    }

    @Override
    public void deleteProductTypeByProductId(Long productId) {
        featureRepo.deleteProductTypeByProductId(productId);
    }
}
