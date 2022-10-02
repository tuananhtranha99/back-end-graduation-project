package com.bezkoder.spring.datajpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Table(name = "color_detail")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ColorDetail {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;

//    @JsonIgnore
//    @OneToMany(mappedBy="colorDetail")
//    private List<Image> images;

//    @ManyToOne
//    @JoinColumn(name="color_id")
//    private Color color;
}