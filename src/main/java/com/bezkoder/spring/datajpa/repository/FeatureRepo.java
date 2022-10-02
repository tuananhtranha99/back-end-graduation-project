package com.bezkoder.spring.datajpa.repository;

import com.bezkoder.spring.datajpa.entity.Brand;
import com.bezkoder.spring.datajpa.entity.Feature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface FeatureRepo extends JpaRepository<Feature, Long> {

    @Modifying
    @Transactional
    @Query("DELETE FROM Feature i WHERE i.product.id = :productId")
    void deleteByProductId(Long productId);

    @Modifying
    @Transactional
    @Query("DELETE FROM ProductType i WHERE i.product.id = :productId")
    void deleteProductTypeByProductId(Long productId);
}
