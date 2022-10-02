package com.bezkoder.spring.datajpa.service;

import com.bezkoder.spring.datajpa.entity.Color;
import com.bezkoder.spring.datajpa.entity.SpecificationType;

public interface SpecificationTypeService {
    SpecificationType retrieve(Long id);
}
