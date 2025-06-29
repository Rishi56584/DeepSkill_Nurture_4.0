package com.example;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MathUtilsTest {

    @Test
    public void testAdd() {
        MathUtils math = new MathUtils();
        assertEquals(7, math.add(3, 4));
    }

    @Test
    public void testSubtract() {
        MathUtils math = new MathUtils();
        assertEquals(2, math.subtract(5, 3));
    }

    @Test
    public void testMultiply() {
        MathUtils math = new MathUtils();
        assertEquals(15, math.multiply(3, 5));
    }
}
