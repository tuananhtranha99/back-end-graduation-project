package com.bezkoder.spring.datajpa.service;

import com.bezkoder.spring.datajpa.entity.Product;
import com.bezkoder.spring.datajpa.entity.PurchaseOrder;
import org.hibernate.criterion.Order;

import java.util.List;

public interface OrderService {
    PurchaseOrder retrieve(Long id);
    PurchaseOrder update(PurchaseOrder order);
    PurchaseOrder create(PurchaseOrder order);
    void delete(Long id);
    List<PurchaseOrder> findOrderList();
}
