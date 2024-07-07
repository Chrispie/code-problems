package com.chrispie.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Child extends PanacheEntityBase {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "inBetween_id")
    private InBetween inBetween;

    public Child(InBetween inBetween) {
        this.inBetween = inBetween;
    }
}
