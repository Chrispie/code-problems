package com.chrispie.service;

import com.chrispie.entity.InBetween;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class DBService {

    @Transactional
    public void saveInBetween(InBetween inBetween) {
        InBetween.persist(inBetween);
    }

    public List<InBetween> findAllInBetweens() {
        return InBetween.listAll();
    }
}
