package com.epam.se06.sets;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertThrows;

class SetTest {

//    @Test(expected = StackOverflowError.class) // JUnit4 API
    @Test
    void hashMapQuiz() {
        Set<Object> set = new HashSet<>(32, 2);
        set.add(set);

        assertThrows(StackOverflowError.class, () -> set.contains(set));
    }
}
