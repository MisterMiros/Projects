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
        if (n % 2 == 0 && n != 2) {
            return false;
        }
        for (int i = 3; i < n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int[] factorize(int n) {
        ArrayList<Integer> primes = new ArrayList<>();
        n /= primeDivider(n, 2, primes);
        for (int i = 3, divider; i <= n; i += 2) {
            divider = primeDivider(n, i, primes);
            n /= divider;
        }
        return CommonTools.intListToArray(primes);
    }

    private static int primeDivider(int n, int i, ArrayList<Integer> primes) {
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

    public static class PrimeIterator {

        private int cur = 1;

        public PrimeIterator() {

        }

        public int current() {
            return cur;
        }

        public int next() {
            if (cur == 1) {
                cur = 2;
                return 2;
            }
            if (cur == 2) {
                cur = 3;
                return 3;
            }
            while (!isPrime(cur += 2)) {}
            return cur;
        }

        public void reset() {
            cur = 1;
        }
    }

}
