package com.epam.se06.sets;

import org.junit.jupiter.api.Test;

import java.util.BitSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BitSetTest {

    @Test
    void name() {
        long mask1 = 0b01010001010;
        long mask2 = 0b01010101110;
        assertEquals(0b01010001010, mask1 & mask2);

        BitSet bitSet1 = new BitSet();
        bitSet1.set(0);
        bitSet1.set(10);
        bitSet1.set(123);

        assertFalse(bitSet1.get(124));
        assertTrue(bitSet1.get(123));

        BitSet bitSet2 = new BitSet();
        bitSet2.set(10);

        bitSet1.and(bitSet2);
        assertTrue(bitSet1.get(10));

        bitSet1.clear(10);
        assertTrue(bitSet1.isEmpty());
    }
}
