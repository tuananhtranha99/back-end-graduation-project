package com.bezkoder.spring.datajpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Table(name = "purchase_order")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PurchaseOrder {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String fullName;
    private String phoneNumber;
    private String address;
    private Integer addressType;
    private String email;
    private String note;
    private String productAndColorAndProductTypeId;
    private Double totalPrice;
    private Integer status;
    private LocalDateTime createdDate;
}
