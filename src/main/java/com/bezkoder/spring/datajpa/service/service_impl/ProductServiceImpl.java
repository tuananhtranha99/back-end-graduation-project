package com.bezkoder.spring.datajpa.service.service_impl;

import com.bezkoder.spring.datajpa.dto.ProductInOrderDTO;
import com.bezkoder.spring.datajpa.entity.Product;
import com.bezkoder.spring.datajpa.repository.ProductRepo;
import com.bezkoder.spring.datajpa.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;


    @Override
    public List<Product> findByCondition(Double minPrice, Double maxPrice, List<Long> checkedBrands) {
        return productRepo.findByCondition(checkedBrands);
    }

    @Override
    public List<Product> findProductsInCart(List<Long> productIdsInCart) {
        return productRepo.findProductsInCart(productIdsInCart);
    }

    @Override
    public Product retrieve(Long id) {
        return productRepo.findById(id).get();
    }

    @Override
    public Product update(Product product) {
        return productRepo.save(product);
    }

    @Override
    public void delete(Long id) {
        productRepo.deleteById(id);
    }

    @Override
    public ProductInOrderDTO findByProductIdAndColorIdAndProductTypeId(Long productId, Long colorId, Long productTypeId) {
        return productRepo.findByProductIdAndColorIdAndProductTypeId(productId, colorId, productTypeId);
    }
}
