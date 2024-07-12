package com.luv2code.junitdemo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;


@TestMethodOrder(MethodOrderer.DisplayName.class)
class DemoUtilsTest {

    DemoUtils demoUtils;

    @BeforeEach
    void setupBeforeEach() {
        demoUtils = new DemoUtils();
    }

    @Test
    @DisplayName("Equals and Not Equals")
    void testEqualsAndNotEquals() {
        assertEquals(6, demoUtils.add(2, 4), "2+4 must be 6");
        assertNotEquals(8, demoUtils.add(2, 4), "2+4 must not be 8");
    }

    @Test
    @DisplayName("Null and Not Null")
    void testNullAndNotNull() {
        String nullStr = null;
        String notNullStr = "Im not null";
        assertNull(demoUtils.checkNull(nullStr), "Object should be null");
        assertNotNull(demoUtils.checkNull(notNullStr), "Object should not be null");
    }

    @Test
    @DisplayName("Same and Not Same")
    void testSameAndNotSame() {
        String str = "Not Luv2Code Academy";
        assertSame(demoUtils.getAcademy(), demoUtils.getAcademyDuplicate(), "Should refer to the same object");
        assertNotSame(str, demoUtils.getAcademy(), "Do not refer to the same object");
    }

    @Test
    @DisplayName("True and False")
    void testTrueAndNotTrue() {
        int gradeOne = 10;
        int gradeTwo = 5;
        assertTrue(demoUtils.isGreater(gradeOne, gradeTwo), "Should be true");
        assertFalse(demoUtils.isGreater(gradeTwo, gradeOne), "Should be false");
    }

    @Test
    @DisplayName("Array Equals")
    void testArrayEquals() {
        String[] strArray = {"A", "B", "C"};
        assertArrayEquals(strArray, demoUtils.getFirstThreeLettersOfAlphabet(), "Array should be equals");
    }

    @Test
    @DisplayName("Iterable Equals")
    void testIterableEquals() {
        List<String> theList = List.of("luv", "2", "code");
        assertIterableEquals(theList, demoUtils.getAcademyInList(), "Expected list should be same as actual list");
    }

    @Test
    @DisplayName("Lines match")
    void testLinesMatch() {
        List<String> theList = List.of("luv", "2", "code");
        assertLinesMatch(theList, demoUtils.getAcademyInList(), "Lines should match");
    }

    @Test
    @DisplayName("Throw and not throw")
    void testThrowAndNotThrow() {
        assertThrows(Exception.class, ()-> demoUtils.throwException(-1), "Should throw exception");
        assertDoesNotThrow(()-> demoUtils.throwException(5), "Should not throw exception");
    }

}
