package com.bezkoder.spring.datajpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Table(name = "specification_type")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SpecificationType {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy="specificationType")
    private List<Specification> specifications;

//    @JsonIgnore
//    @ManyToMany(mappedBy = "specificationType")
//    List<Product> products;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpecificationType that = (SpecificationType) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
