package com.bezkoder.spring.datajpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Table(name = "color")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Color {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String name;

//    @JsonIgnore
//    @OneToMany(mappedBy="color")
//    private List<ColorDetail> colorDetail;

    @JsonIgnore
    @OneToMany(mappedBy="color")
    private List<Image> images;

//    @JsonIgnore
//    @ManyToMany(mappedBy = "colors")
//    List<Product> products;
}
