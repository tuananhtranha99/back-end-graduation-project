package com.bezkoder.spring.datajpa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestOrderDTO {
    private AddressInfoDTO addressInfo;
    private List<ProductInCartDTO> products;
    private Long orderId;
    private Integer status;
}
