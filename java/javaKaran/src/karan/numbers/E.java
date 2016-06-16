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

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 *
 * @author Miros
 */
public class E {

    public static BigDecimal e_iteration(int i, BigDecimal fact) {
        return BigDecimal.ONE.divide(fact, new MathContext(1000, RoundingMode.FLOOR));
    }

    public static BigDecimal findEToNthDigit(int n) throws IllegalArgumentException {
        if (n < 1) {
            throw new IllegalArgumentException("negative or zero argument (" + n + ")");
        }
        if (n > 1000) {
            throw new IllegalArgumentException("argument is greater than 1000 (" + n + ")");
        }
        if (n == 1) {
            return new BigDecimal(2);
        }
        BigDecimal e = BigDecimal.ONE;
        BigDecimal fact = BigDecimal.ONE;
        for (int i = 1; i < n + 5; i++) {
            fact = fact.multiply(new BigDecimal(i));
            e = e.add(e_iteration(i, fact));
        }
        return e.round(new MathContext(n, RoundingMode.FLOOR));
    }
    
}
