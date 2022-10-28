package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class urinalsTest {
    @Test
    public void TestCase() { //created a JUnit test case that fails
        System.out.println("====== Jyothirmai Kantipudi == TEST ONE EXECUTED =======");
        assertEquals(1, urinals.numberOfUrinals("1001"));
    }
}