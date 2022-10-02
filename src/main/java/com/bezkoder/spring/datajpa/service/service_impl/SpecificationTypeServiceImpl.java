package com.bezkoder.spring.datajpa.service.service_impl;

import com.bezkoder.spring.datajpa.entity.Color;
import com.bezkoder.spring.datajpa.entity.SpecificationType;
import com.bezkoder.spring.datajpa.repository.ColorRepo;
import com.bezkoder.spring.datajpa.repository.SpecificationTypeRepo;
import com.bezkoder.spring.datajpa.service.ColorService;
import com.bezkoder.spring.datajpa.service.SpecificationTypeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class SpecificationTypeServiceImpl implements SpecificationTypeService {

    private final SpecificationTypeRepo specificationTypeRepo;


    @Override
    public SpecificationType retrieve(Long id) {
        return specificationTypeRepo.findById(id).get();
    }
}
