package com.bezkoder.spring.datajpa.service;

import com.bezkoder.spring.datajpa.dto.ProductInOrderDTO;
import com.bezkoder.spring.datajpa.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findByCondition(Double minPrice, Double maxPrice, List<Long> checkedBrands);
    List<Product> findProductsInCart(List<Long> productIdsInCart);
    Product retrieve(Long id);
    Product update(Product product);
    void delete(Long id);
    ProductInOrderDTO findByProductIdAndColorIdAndProductTypeId(Long productId, Long colorId, Long productTypeId);
}
