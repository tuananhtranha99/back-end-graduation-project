package com.bezkoder.spring.datajpa.repository;

import com.bezkoder.spring.datajpa.entity.Color;
import com.bezkoder.spring.datajpa.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ColorRepo extends JpaRepository<Color, Long> {

}
