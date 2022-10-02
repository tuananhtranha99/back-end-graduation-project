package com.bezkoder.spring.datajpa.service.service_impl;

import com.bezkoder.spring.datajpa.entity.Product;
import com.bezkoder.spring.datajpa.entity.PurchaseOrder;
import com.bezkoder.spring.datajpa.repository.OrderRepo;
import com.bezkoder.spring.datajpa.repository.ProductRepo;
import com.bezkoder.spring.datajpa.service.OrderService;
import com.bezkoder.spring.datajpa.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final OrderRepo orderRepo;


    @Override
    public PurchaseOrder retrieve(Long id) {
        return orderRepo.findById(id).get();
    }

    @Override
    public PurchaseOrder update(PurchaseOrder order) {
        return orderRepo.save(order);
    }

    @Override
    public PurchaseOrder create(PurchaseOrder order) {
        return orderRepo.save(order);
    }

    @Override
    public void delete(Long id) {
        orderRepo.deleteById(id);
    }

    @Override
    public List<PurchaseOrder> findOrderList() {
        return orderRepo.findAll();
    }
}
