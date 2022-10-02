package com.bezkoder.spring.datajpa.repository;

import com.bezkoder.spring.datajpa.entity.Feature;
import com.bezkoder.spring.datajpa.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface ImageRepo extends JpaRepository<Image, Long> {

    @Modifying
    @Transactional
    @Query("DELETE FROM Image i WHERE i.product.id = :productId")
    void deleteByProductId(Long productId);
}
