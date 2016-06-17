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

import java.util.ArrayList;

/**
 *
 * @author Miros
 */
public class PrimeTools {

    public static boolean isPrime(int n) {
        return false;
    }

    public static int[] factorize(int n) {
        ArrayList<Integer> primes = new ArrayList<>();
        n = firstTwoPrimes(n, primes);
        for (int i = 5, divider; i <= n; i += 2) {
            divider = primeDivider(n, i, primes);
            n /= divider;
        }
        return CommonTools.intListToArray(primes);
    }

    private static int primeDivider(int n, int i, ArrayList<Integer> primes) {
        if (i % 3 == 0 && i != 3) {
            return 1;
        }
        int divider = 1;
        while (n % i == 0) {
            n /= i;
            divider *= i;
        }
        if (divider != 1) {
            primes.add(divider);
        }
        return divider;
    }

    private static int firstTwoPrimes(int n, ArrayList<Integer> primes) {
        int divider = primeDivider(n, 2, primes);
        n /= divider;
        divider = primeDivider(n, 3, primes);
        n /= divider;
        return n;
    }

    public static class PrimeIterator {

        private int cur = 0;

        public PrimeIterator() {

        }

        public int current() {
            return 0;
        }

        public int next() {
            return 0;
        }

        public void reset() {
        }
    }

}
