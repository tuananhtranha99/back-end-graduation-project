package com.bezkoder.spring.datajpa.repository;

import com.bezkoder.spring.datajpa.entity.Color;
import com.bezkoder.spring.datajpa.entity.SpecificationType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecificationTypeRepo extends JpaRepository<SpecificationType, Long> {

}
