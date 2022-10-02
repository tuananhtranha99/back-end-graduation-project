package com.bezkoder.spring.datajpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Table(name = "product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String name;
    private String description;
    private String imgPath;
//    private Integer hasFreeShipping;
//    private Double rating;

    @ManyToOne
    @JoinColumn(name="brand_id")
    private Brand brand;

    @OneToMany(mappedBy="product")
    private List<ProductType> productTypes;

    @OneToMany(mappedBy="product")
    private List<Feature> features;

    @OneToMany(mappedBy="product")
    private List<Image> images;

//    @ManyToMany
//    @JoinTable(
//            name = "product_color",
//            joinColumns = @JoinColumn(name = "product_id"),
//            inverseJoinColumns = @JoinColumn(name = "color_id"))
//    private List<Color> colors;

//    @ManyToMany
//    @JoinTable(
//            name = "product_specification_type",
//            joinColumns = @JoinColumn(name = "product_id"),
//            inverseJoinColumns = @JoinColumn(name = "specification_type_id"))
//    private List<SpecificationType> specificationType;

    @OneToMany(mappedBy="product")
    private List<Specification> specifications;


}
