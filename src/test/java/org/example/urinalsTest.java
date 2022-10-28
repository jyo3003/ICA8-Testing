package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class urinalsTest {
    @Test
    public void TestCaseOne() {
        System.out.println("====== Jyothirmai Kantipudi == TEST ONE EXECUTED =======");
        assertEquals(0, urinals.numberOfUrinals("1001"));
    }

    @Test
    public void TestCaseTwo() {
        System.out.println("====== Jyothirmai Kantipudi == TEST TWO EXECUTED =======");
        assertEquals(-1, urinals.numberOfUrinals("1101"));
    }
    @Test
    public void TestCaseThree() {
        System.out.println("====== Jyothirmai Kantipudi == TEST THREE EXECUTED =======");
        assertEquals(0, urinals.numberOfUrinals("1"));
    }

    @Test
    public void TestCaseFour() {
        System.out.println("====== Jyothirmai Kantipudi == TEST FOUR EXECUTED =======");
        assertEquals(1, urinals.numberOfUrinals("0"));
    }

    @Test
    public void TestCaseFive() {
        System.out.println("====== Jyothirmai Kantipudi == TEST FIVE EXECUTED =======");
        assertEquals(-1, urinals.numberOfUrinals("111011"));
    }

    @Test
    public void TestCaseSix() {
        System.out.println("====== Jyothirmai Kantipudi == TEST SIX EXECUTED =======");
        assertEquals(3, urinals.numberOfUrinals("00000100"));
    }
}