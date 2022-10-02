package com.bezkoder.spring.datajpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Table(name = "feature")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Feature {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String content;

    @ManyToOne
    @JoinColumn(name="product_id")
    @JsonIgnore
    private Product product;
}
