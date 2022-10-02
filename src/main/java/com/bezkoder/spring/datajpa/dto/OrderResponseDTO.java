package com.bezkoder.spring.datajpa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponseDTO {
    private Long id;
    private String fullName;
    private String phoneNumber;
    private String address;
    private Integer addressType;
    private String email;
    private String note;
    private Double totalPrice;
    private Integer status;
    private LocalDateTime createdDate;
    private List<ProductInOrderDTO> products;

}
