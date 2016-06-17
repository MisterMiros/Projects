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
public class primeFactorizationTest {

    public primeFactorizationTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("Testing \"Prime factorization\"");
    }

    @Test
    public void testFactorization() {
        int[] numbers = new int[]{13, 2287, 64800, 28823361, 62615533};
        int[][] factorized = new int[][]{
            {13},
            {2287},
            {32, 81, 25},
            {3, 7, 19, 29, 47, 53},
            {7907, 7919}
        };
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("testing " + numbers[i] + " factorization");
            int[] result = PrimeTools.factorize(numbers[i]);
            assertArrayEquals(factorized[i], result);
        }
    }
}
