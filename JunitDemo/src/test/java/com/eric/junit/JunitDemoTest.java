package com.eric.junit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class JunitDemoTest {

    JunitDemo junitDemo = new JunitDemo();

    @Test
    void testEqualsAndNotEquals() {
        assertEquals(6, junitDemo.add(2, 4), "2+4 must be 6");
        assertNotEquals(8, junitDemo.add(2, 4), "2+4 must not be 8");
    }

    @Test
    void testNullAndNotNull() {
        String nullStr = null;
        String notNullStr = "Im not null";
        assertNull(junitDemo.checkNull(nullStr), "Object should be null");
        assertNotNull(junitDemo.checkNull(notNullStr), "Object should not be null");
    }
}
