package com.bezkoder.spring.datajpa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressInfoDTO {
    private String fullName;
    private String phoneNumber;
    private String addressDetail;
    private String email;
    private String note;
    private Integer addressType;
}
