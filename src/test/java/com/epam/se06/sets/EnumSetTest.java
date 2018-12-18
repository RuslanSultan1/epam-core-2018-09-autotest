package com.epam.se06.sets;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.EnumSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class EnumSetTest {

    private SetFactory<Season> factory;

    public EnumSetTest() {
        System.out.println("Constructor called");
    }

    @BeforeAll
    static void commonSetUp() {
        System.out.println("Before all");
    }

    @BeforeEach
    void setUp() {
        factory = () -> EnumSet.noneOf(Season.class);
        System.out.println("setUp method called");
    }

    @Test
    @SuppressWarnings("OverwrittenKey")
    void simple() {
        Set<Season> seasons = factory.createSet();

        seasons.add(Season.WINTER);
        seasons.add(Season.SUMMER);
        seasons.add(Season.SUMMER);

        assertEquals(2, seasons.size());
    }

    @Test
    void second() {
        fail(new IllegalStateException());
    }

    @AfterEach
    void tearDown() {
        System.out.println("tearDown called");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("afterAll called");
    }
}

@FunctionalInterface
interface SetFactory<T> {

    Set<T> createSet();
}

enum Season {
    WINTER,
    SPRING,
    SUMMER,
    AUTUMN
}
