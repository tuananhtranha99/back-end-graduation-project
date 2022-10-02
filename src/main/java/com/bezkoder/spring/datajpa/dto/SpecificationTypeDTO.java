package com.bezkoder.spring.datajpa.dto;

import com.bezkoder.spring.datajpa.entity.Specification;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SpecificationTypeDTO {
    private String name;
    private List<Specification> specificationList;
}
