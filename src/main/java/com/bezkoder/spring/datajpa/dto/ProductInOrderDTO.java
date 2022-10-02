package com.bezkoder.spring.datajpa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductInOrderDTO {
    private Long productId;
    private String productName;
    private String brandName;
    private Long productTypeId;
    private String productTypeName;
    private Double price;
    private Long colorId;
    private String colorName;

}
