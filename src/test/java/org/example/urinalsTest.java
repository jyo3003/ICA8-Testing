package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class urinalsTest {
    @Test
    public void TestCaseOne() { //created a JUnit test case that fails
        System.out.println("====== Jyothirmai Kantipudi == TEST ONE EXECUTED =======");
        assertEquals(0, urinals.numberOfUrinals("1001"));
    }

    @Test
    public void TestCaseTwo() { //created a JUnit test case that fails
        System.out.println("====== Jyothirmai Kantipudi == TEST TWO EXECUTED =======");
        assertEquals(0, urinals.numberOfUrinals("1101"));
    }
    @Test
    public void TestCaseThree() { //created a JUnit test case that fails
        System.out.println("====== Jyothirmai Kantipudi == TEST THREE EXECUTED =======");
        assertEquals(0, urinals.numberOfUrinals("1"));
    }

    @Test
    public void TestCaseFour() { //created a JUnit test case that fails
        System.out.println("====== Jyothirmai Kantipudi == TEST FOUR EXECUTED =======");
        assertEquals(1, urinals.numberOfUrinals("0"));
    }
}