package com.bezkoder.spring.datajpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Table(name = "image")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Image {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;

    private String imgPath;
    private String name;

//    @ManyToOne
//    @JoinColumn(name="color_detail_id")
//    private ColorDetail colorDetail;

    @ManyToOne
    @JoinColumn(name="color_id")
    private Color color;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;
}
