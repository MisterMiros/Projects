/*
 * Copyright (C) 2016 Miros
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package karan.numbers;

import org.junit.Test;
import org.junit.BeforeClass;
import static org.junit.Assert.*;

/**
 *
 * @author Miros
 */
public class fibonacciSequenceTest {

    public fibonacciSequenceTest() {
    }

    private static long[][] sequences;

    @BeforeClass
    public static void setUpClass() {
        System.out.println("Testing \"Fibonacci sequence\"");
        
        sequences = new long[][]{
            {1, 1},
            {1, 1, 2, 3, 5},
            {1, 1, 2, 3, 5, 8, 13, 21, 34, 55},
            {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296, 433494437, 701408733, 1134903170, 1836311903, 2971215073L, 4807526976L, 7778742049L, 12586269025L}
        };
    }

    @Test
    public void findToNthTest() {
        int[] ns = new int[]{2, 5, 10, 50};
        for (int i = 0; i < ns.length; i++) {
            assertArrayEquals(sequences[i], Fibonacci.fibonacciToNth(ns[i]));
        }
    }
    
    @Test
    public void findToLimitTest() {
        long[] limits = new long[] {1, 5, 55, 12586269025L};
        for (int i = 0; i < limits.length; i++) {
            assertArrayEquals(sequences[i], Fibonacci.fibonacciToLimit(limits[i]));
        }
    }
    
    @Test
    public void checkWrongValues() {
        System.out.println("should throw an exception");
        try {
            System.out.println("when given argument lesser than 1");
            Fibonacci.fibonacciToNth(0);
            fail("expected IllegalArgumentException");
        } catch (IllegalArgumentException ex) {
        }try {
            Fibonacci.fibonacciToLimit(0);
            fail("expected IllegalArgumentException");
        } catch (IllegalArgumentException ex) {
        }
        try {
            System.out.println("when given argument for nth search greater than 50");
            Fibonacci.fibonacciToNth(51);
            fail("expected IllegalArgumentException");
        } catch (IllegalArgumentException ex) {
        }
    }

}
