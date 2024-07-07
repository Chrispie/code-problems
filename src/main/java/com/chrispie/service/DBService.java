package com.chrispie.service;

import com.chrispie.entity.InBetween;
import com.chrispie.entity.Parent;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class DBService {

    @Transactional
    public void saveParent(Parent parent) {
        Parent.persist(parent);
    }

    public List<Parent> findAllParents() {
         return Parent.listAll();
    }

    @Transactional
    public void saveInBetween(InBetween inBetween) {
        InBetween.persist(inBetween);
    }

    public List<InBetween> findAllInBetweens() {
        return InBetween.listAll();
    }
}
