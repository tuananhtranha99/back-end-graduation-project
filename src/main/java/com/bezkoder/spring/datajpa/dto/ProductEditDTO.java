package com.bezkoder.spring.datajpa.dto;

import com.bezkoder.spring.datajpa.entity.Feature;
import com.bezkoder.spring.datajpa.entity.Image;
import com.bezkoder.spring.datajpa.entity.ProductType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductEditDTO {
    private Long productId;
    private Long brandId;
    private String description;
    private List<String> features;
    private List<ProductType> productTypes;
//    private MultipartFile[] fileList;
    private List<ImageDTO> imgList;
    private String name;
}
