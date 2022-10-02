package com.bezkoder.spring.datajpa.service.service_impl;

import com.bezkoder.spring.datajpa.entity.Feature;
import com.bezkoder.spring.datajpa.entity.Image;
import com.bezkoder.spring.datajpa.repository.FeatureRepo;
import com.bezkoder.spring.datajpa.repository.ImageRepo;
import com.bezkoder.spring.datajpa.service.FeatureService;
import com.bezkoder.spring.datajpa.service.ImageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ImageServiceImpl implements ImageService {

    private final ImageRepo imageRepo;

    @Override
    public void saveAll(List<Image> list) {
        imageRepo.saveAll(list);
    }

    @Override
    public void deleteByProductId(Long productId) {
        imageRepo.deleteByProductId(productId);
    }
}
