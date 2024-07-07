package com.chrispie;

import com.chrispie.entity.Child;
import com.chrispie.entity.InBetween;
import com.chrispie.entity.Parent;
import com.chrispie.service.DBService;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
public class Tests {

    @Inject
    DBService dbService;

    @Test
    void testInBetweens() {
        final Parent parentInstance = new Parent();
        final InBetween inBetweenInstance = new InBetween(parentInstance);

        final Child childInstance = new Child(inBetweenInstance);
        inBetweenInstance.setChildren(List.of(childInstance));          // If this is not added then it does not persist the children

        dbService.saveInBetween(inBetweenInstance);
        final List<Child> panacheEntityBases = Child.listAll();

        final List<InBetween> allInBetweens = dbService.findAllInBetweens();
        //Has InBetweens

        assertEquals(1, allInBetweens.size());

        //Has Parent
        assertEquals(1, allInBetweens.get(0).getParent().getId());

        //Has children
        assertEquals(1, allInBetweens.get(0).getChildren().size());
        assertEquals(1, allInBetweens.get(0).getChildren().get(0).getId());
        assertEquals(1, allInBetweens.get(0).getChildren().get(0).getInBetween().getId());

    }
}
