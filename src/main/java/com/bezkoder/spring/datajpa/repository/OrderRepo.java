package com.bezkoder.spring.datajpa.repository;

import com.bezkoder.spring.datajpa.entity.Product;
import com.bezkoder.spring.datajpa.entity.PurchaseOrder;
import org.hibernate.criterion.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepo extends JpaRepository<PurchaseOrder, Long> {

}
