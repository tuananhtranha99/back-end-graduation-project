package com.bezkoder.spring.datajpa.dto;

import com.bezkoder.spring.datajpa.entity.Brand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.GenerationType.AUTO;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestProductDTO {
    private Integer minprice;
    private Integer maxPrice;
    private List<Integer> checkedBrands;
}
