package com.bezkoder.spring.datajpa.controller;

import com.bezkoder.spring.datajpa.dto.*;
import com.bezkoder.spring.datajpa.entity.Product;
import com.bezkoder.spring.datajpa.entity.PurchaseOrder;
import com.bezkoder.spring.datajpa.entity.Specification;
import com.bezkoder.spring.datajpa.entity.SpecificationType;
import com.bezkoder.spring.datajpa.service.ColorService;
import com.bezkoder.spring.datajpa.service.OrderService;
import com.bezkoder.spring.datajpa.service.ProductService;
import com.bezkoder.spring.datajpa.service.SpecificationTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/purchase-order")
@RequiredArgsConstructor
public class PurchaseOrderController {
    private final OrderService orderService;
    private final ProductService productService;

    @PostMapping("/create-order")
    public ResponseEntity<ResponseDTO> createOrder(@RequestBody RequestOrderDTO dto){
        ResponseDTO response = new ResponseDTO();
        PurchaseOrder order;
        StringBuilder productsInCartBuilder = new StringBuilder();

        // convert form list products to string, each product is seperated by a hyphen
        for (ProductInCartDTO o : dto.getProducts()) {
            productsInCartBuilder.append(o.getProductId()).append(",")
                    .append(o.getColorId()).append(",")
                    .append(o.getProductTypeId()).append("-");
        }

        String productsInCartString = productsInCartBuilder.toString();


        order = PurchaseOrder.builder()
                .fullName(dto.getAddressInfo().getFullName())
                .address(dto.getAddressInfo().getAddressDetail())
                .phoneNumber(dto.getAddressInfo().getPhoneNumber())
                .addressType(dto.getAddressInfo().getAddressType())
                .email(dto.getAddressInfo().getEmail())
                .note(dto.getAddressInfo().getNote())
                .status(0)
                .productAndColorAndProductTypeId(productsInCartString.substring(0, productsInCartString.length()-1)).build();

        response.setStatusCode(200);
        response.setContent(orderService.create(order));
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/find-order")
    public ResponseEntity<ResponseDTO> getProductsInCart(){
        ResponseDTO response = new ResponseDTO();
        response.setStatusCode(200);
        response.setContent(orderService.findOrderList());
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/get-detail")
    public ResponseEntity<ResponseDTO> getOrderDetail(@RequestParam Long orderId){
        ResponseDTO response = new ResponseDTO();
        OrderResponseDTO orderResponseDTO = new OrderResponseDTO();
        PurchaseOrder order = orderService.retrieve(orderId);
        List<ProductInOrderDTO> products = new ArrayList<>();

        List<Long> idArray;
        String[] arrayOfProductAndColorAndProductTypeId = order.getProductAndColorAndProductTypeId().split("-");
        for (String s : arrayOfProductAndColorAndProductTypeId) {

            // convert from String list to Long list
            idArray = Stream.of(s.split(",")).map(Long::valueOf).collect(Collectors.toList());

            products.add(productService.findByProductIdAndColorIdAndProductTypeId(idArray.get(0),idArray.get(1), idArray.get(2)));
        }

        //mapping entity to dto
        orderResponseDTO.setId(order.getId());
        orderResponseDTO.setFullName(order.getFullName());
        orderResponseDTO.setPhoneNumber(order.getPhoneNumber());
        orderResponseDTO.setAddress(order.getAddress());
        orderResponseDTO.setAddressType(order.getAddressType());
        orderResponseDTO.setEmail(order.getEmail());
        orderResponseDTO.setNote(order.getNote());
        orderResponseDTO.setTotalPrice(order.getTotalPrice());
        orderResponseDTO.setStatus(order.getStatus());
        orderResponseDTO.setCreatedDate(order.getCreatedDate());
        orderResponseDTO.setProducts(products);

        response.setStatusCode(200);
        response.setContent(orderResponseDTO);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/update-status")
    public ResponseEntity<ResponseDTO> updateOrderStatus(@RequestBody RequestOrderDTO dto){
        ResponseDTO response = new ResponseDTO();
        PurchaseOrder order = orderService.retrieve(dto.getOrderId());
        order.setStatus(dto.getStatus());
        order = orderService.update(order);
        response.setStatusCode(200);
        response.setContent(order);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping
    public ResponseEntity<ResponseDTO> deleteOrder(@RequestParam Long orderId){
        ResponseDTO response = new ResponseDTO();
        orderService.delete(orderId);
        response.setStatusCode(200);
        return ResponseEntity.ok().body(response);
    }
}

