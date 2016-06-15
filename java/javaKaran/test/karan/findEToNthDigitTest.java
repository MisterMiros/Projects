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
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Miros
 */
public class findEToNthDigitTest {

    @BeforeClass
    public static void setUpClass() {
        System.out.println("Testing \"Calculating e to nth digit\"");
    }

    @Test
    public void checkDifferentDigitsCount() {
        int[] digits = {1, 5, 10, 50, 100, 1000};
        BigDecimal[] e_exp = {
            new BigDecimal("2"),
            new BigDecimal("2.7182"),
            new BigDecimal("2.718281828"),
            new BigDecimal("2.7182818284590452353602874713526624977572470936999"),
            new BigDecimal("2.718281828459045235360287471352662497757247093699959574966967627724076630353547594571382178525166427"),
            new BigDecimal("2.718281828459045235360287471352662497757247093699959574966967627724076630353547594571382178525166427427466391932003059921817413596629043572900334295260595630738132328627943490763233829880753195251019011573834187930702154089149934884167509244761460668082264800168477411853742345442437107539077744992069551702761838606261331384583000752044933826560297606737113200709328709127443747047230696977209310141692836819025515108657463772111252389784425056953696770785449969967946864454905987931636889230098793127736178215424999229576351482208269895193668033182528869398496465105820939239829488793320362509443117301238197068416140397019837679320683282376464804295311802328782509819455815301756717361332069811250996181881593041690351598888519345807273866738589422879228499892086805825749279610484198444363463244968487560233624827041978623209002160990235304369941849146314093431738143640546253152096183690888707016768396424378140592714563549061303107208510383750510115747704171898610687396965521267154688957035035")
        };
        for (int i = 0; i < digits.length; i++) {
            System.out.println("find first " + digits[i] + " digits of pi");
            BigDecimal e_act = Numbers.findEToNthDigit(digits[i]);
            assertEquals(e_exp[i], e_act);
        }
    }

    @Test
    public void checkWrongValues() {
        System.out.println("should throw an exception");
        try {
            System.out.println("when given argument lesser than 1");
            Numbers.findEToNthDigit(0);
            fail("expected IllegalArgumentException");
        } catch (IllegalArgumentException ex) {
        }
        try {
            System.out.println("when given argument greater than 1000");
            Numbers.findEToNthDigit(1001);
            fail("expected IllegalArgumentException");
        } catch (IllegalArgumentException ex) {
        }
    }

}
