package com.example.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SlidingWindowTest {

    @Test
    void average_t0() {
        double[] numbers = new double[] { 1, 3, 2, 6, -1 };
        double result = SlidingWindow.average(numbers);
        assertEquals(2.2, result);
    }

    @Test
    void average_t1() {
        double[] numbers = new double[] { 3, 2, 6, -1, 4 };
        double result = SlidingWindow.average(numbers);
        assertEquals(2.8, result);
    }

    @Test
    void average_t2() {
        double[] numbers = new double[] { 2, 6, -1, 4, 1 };
        double result = SlidingWindow.average(numbers);
        assertEquals(2.4, result);
    }

    @Test
    void findAverages_t0() {
        double[] numbers = new double[] { 1, 3, 2, 6, -1, 4, 1, 8, 2 };
        double[] result = SlidingWindow.findAverages(5, numbers);
        double[] expected = new double[] { 2.2, 2.8, 2.4, 3.6, 2.8 };
        assertArrayEquals(expected, result);

    }

    @Test
    void maximumSum() {
        int[] numbers = new int[] { 2, 1, 5, 1, 3, 2 };
        int result = SlidingWindow.maximumSum(3, numbers);
        assertEquals(9, result);
    }

    @Test
    void smallestSubArray_t0() {
        int[] numbers = new int[] { 2, 1, 5, 2, 3, 2 };
        int result = SlidingWindow.smallestSubArray(7, numbers);
        assertEquals(2, result);
    }
    @Test
    void smallestSubArray_t1() {
        int[] numbers = new int[] { 2, 1, 5, 2, 8 };
        int result = SlidingWindow.smallestSubArray(7, numbers);
        assertEquals(1, result);
    }

    @Test
    void longestSubstringKDistinct_t0() {
        int result = SlidingWindow.longestSubstringKDistinct(2, "araaci");
        assertEquals(4, result);

    }

    @Test
    void longestSubstringKDistinct_t1() {
        int result = SlidingWindow.longestSubstringKDistinct(1, "araaci");
        assertEquals(2, result);

    }

    @Test
    void longestSubstringKDistinct_t2() {
        int result = SlidingWindow.longestSubstringKDistinct(3, "araaci");
        assertEquals(5, result);
    }

}