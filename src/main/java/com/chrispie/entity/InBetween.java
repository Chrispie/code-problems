package com.chrispie.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class InBetween extends PanacheEntityBase {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_id")
    private Parent parent;

    @OneToMany(mappedBy = "inBetween", cascade = CascadeType.ALL)
    private List<Child> children;

    public InBetween(Parent parent) {
        this.parent = parent;
    }
}
