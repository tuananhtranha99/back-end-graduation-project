package com.bezkoder.spring.datajpa.repository;

import com.bezkoder.spring.datajpa.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepo extends JpaRepository<Brand, Long> {
}
