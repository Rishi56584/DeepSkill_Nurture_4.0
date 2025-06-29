package com.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class StringUtilsTest {

    private StringUtils utils;

    @Before
    public void setUp() {
        utils = new StringUtils();
        System.out.println("Setup - StringUtils created");
    }

    @After
    public void tearDown() {
        utils = null;
        System.out.println("Teardown - StringUtils cleared");
    }

    @Test
    public void testReverse() {
        // Arrange done in @Before

        // Act
        String result = utils.reverse("hello");

        // Assert
        assertEquals("olleh", result);
    }

    @Test
    public void testIsPalindromeTrue() {
        // Arrange done in @Before

        // Act
        boolean result = utils.isPalindrome("madam");

        // Assert
        assertTrue(result);
    }

    @Test
    public void testIsPalindromeFalse() {
        // Arrange done in @Before

        // Act
        boolean result = utils.isPalindrome("hello");

        // Assert
        assertFalse(result);
    }
}
