package com.bezkoder.spring.datajpa.repository;

import com.bezkoder.spring.datajpa.entity.Feature;
import com.bezkoder.spring.datajpa.entity.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface ProductTypeRepo extends JpaRepository<ProductType, Long> {
    @Modifying
    @Transactional
    @Query("DELETE FROM ProductType i WHERE i.product.id = :productId")
    void deleteProductTypeByProductId(Long productId);
}
