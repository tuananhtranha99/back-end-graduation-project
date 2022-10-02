package com.bezkoder.spring.datajpa.dto;

import com.bezkoder.spring.datajpa.entity.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

import static javax.persistence.GenerationType.AUTO;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseProductDTO {

    private Long id;
    private String name;
    private String description;
    private String imgPath;
    private Integer hasFreeShipping;
    private Double rating;
    private Brand brand;
    private List<ProductType> productTypes;
    private List<Feature> features;
    private List<Image> images;
    private List<Specification> specifications;
    private List<SpecificationTypeDTO> specificationTypeDTOs;
}
