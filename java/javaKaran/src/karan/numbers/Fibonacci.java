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
import java.util.Iterator;

/**
 *
 * @author Miros
 */
public class Fibonacci {
    
    public static class FibonacciIterator {

        private long prev = 1;
        private long cur = 1;
        private int position = 2;

        public FibonacciIterator() {

        }

        public int position() {
            return position;
        }

        public long current() {
            return cur;
        }

        public long previous() {
            return prev;
        }

        public long next() {
            cur += prev;
            prev = cur - prev;
            position++;
            return cur;
        }

        public void reset() {
            prev = cur = 1;
            position = 2;
        }
    }

    public static long[] fibonacciToNth(int n) throws IllegalArgumentException {
        if (n > 50 || n < 1) {
            throw new IllegalArgumentException("argument is too big or too small (" + n + ")");
        }
        if (n == 1) {
            return new long[]{1};
        }
        FibonacciIterator factory = new FibonacciIterator();
        long[] sequence = new long[n];
        sequence[0] = 1;
        sequence[1] = 1;
        while (factory.position() < n) {
            sequence[factory.position()] = factory.next();
        }
        return sequence;
    }

    public static long[] fibonacciToLimit(long limit) throws IllegalArgumentException {
        if (limit < 1) {
            throw new IllegalArgumentException("argument is lesser than 1 (" + limit + ")");
        }
        FibonacciIterator factory = new FibonacciIterator();
        ArrayList<Long> sequence = new ArrayList<>();
        sequence.add(1L);
        sequence.add(1L);
        while (factory.next() <= limit) {
            sequence.add(factory.current());
        }
        long[] result = new long[sequence.size()];
        Iterator<Long> it = sequence.iterator();
        for (int i = 0; it.hasNext(); i++) {
            result[i] = it.next();
        }
        return result;
    }
    
}
