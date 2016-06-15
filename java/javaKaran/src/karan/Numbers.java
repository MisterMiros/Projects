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
package karan;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 *
 * @author Miros
 */
public class Numbers {

    public static BigDecimal findPiToNthDigit(int n)
            throws IllegalArgumentException {
        if (n < 1) {
            throw new IllegalArgumentException("negative or zero argument (" + n + ")");
        }
        if (n > 1000) {
            throw new IllegalArgumentException("argument is greater than 1000 (" + n + ")");
        }
        if (n == 1) {
            return new BigDecimal(3);
        }
        BigDecimal pi = new BigDecimal(0);
        for (int i = 0; i < n; i++) {
            pi = pi.add(pi_iteration(i));
        }
        return pi.round(new MathContext(n, RoundingMode.FLOOR));
    }

    private static BigDecimal pi_iteration(int i) {
        BigDecimal k8 = new BigDecimal(8 * i);
        BigDecimal denom1 = k8.add(BigDecimal.ONE);
        BigDecimal denom2 = k8.add(new BigDecimal(4));
        BigDecimal denom3 = k8.add(new BigDecimal(5));
        BigDecimal denom4 = k8.add(new BigDecimal(6));

        BigDecimal denom = denom1.multiply(denom2).multiply(denom3).multiply(denom4);

        BigDecimal numer1 = denom2.multiply(denom3).multiply(denom4).multiply(new BigDecimal(4));
        BigDecimal numer2 = denom1.multiply(denom3).multiply(denom4).multiply(new BigDecimal(2));
        BigDecimal numer3 = denom1.multiply(denom2).multiply(denom4);
        BigDecimal numer4 = denom1.multiply(denom2).multiply(denom3);

        BigDecimal numer = numer1.subtract(numer2).subtract(numer3).subtract(numer4);

        BigDecimal multiplier = numer.divide(denom, new MathContext(1000, RoundingMode.FLOOR));

        BigDecimal value = BigDecimal.ONE.divide((new BigDecimal(16)).pow(i));

        return value.multiply(multiplier);
    }
    
    public static BigDecimal findEToNthDigit(int n)
            throws IllegalArgumentException {
        if (n < 1) {
            throw new IllegalArgumentException("negative or zero argument (" + n + ")");
        }
        if (n > 1000) {
            throw new IllegalArgumentException("argument is greater than 1000 (" + n + ")");
        }
        if (n == 1) {
            return new BigDecimal(2);
        }
        BigDecimal e = BigDecimal.ONE, fact = BigDecimal.ONE;
        for (int i = 1; i < n+5; i++) {
            fact = fact.multiply(new BigDecimal(i));
            e = e.add(e_iteration(i, fact));
        }
        return e.round(new MathContext(n, RoundingMode.FLOOR));
    }
    
    public static BigDecimal e_iteration(int i, BigDecimal fact) {
        return BigDecimal.ONE.divide(fact, new MathContext(1000, RoundingMode.FLOOR));
    }
}
