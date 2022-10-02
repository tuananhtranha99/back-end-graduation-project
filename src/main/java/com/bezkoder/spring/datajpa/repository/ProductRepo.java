package com.bezkoder.spring.datajpa.repository;

import com.bezkoder.spring.datajpa.dto.ProductInOrderDTO;
import com.bezkoder.spring.datajpa.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p WHERE (coalesce(:checkedBrands, null) IS NULL OR brand.id IN (:checkedBrands)) ")
    List<Product> findByCondition(List<Long> checkedBrands);

    @Query("SELECT p FROM Product p WHERE (coalesce(:productIdsInCart, null) IS NULL OR p.id IN (:productIdsInCart))")
    List<Product> findProductsInCart(List<Long> productIdsInCart);

    @Query("select new com.bezkoder.spring.datajpa.dto.ProductInOrderDTO(p.id, p.name, b.name, p1.id, p1.name, p1.price, c.id, c.name) from Product p" +
            " join ProductType p1 on p1.product.id = p.id" +
            " join Image i on i.product.id = p.id" +
            " join Color c on c.id = i.color.id" +
            " join Brand b on b.id = p.brand.id where p.id = :productId and c.id = :colorId and p1.id = :productTypeId" +
            " group by p.id, p.name, b.name, p1.id, p1.name, p1.price, c.id, c.name")
    ProductInOrderDTO findByProductIdAndColorIdAndProductTypeId(Long productId, Long colorId, Long productTypeId);
}
