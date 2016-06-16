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
import java.math.BigDecimal;

/**
 *
 * @author Miros
 */
public class findPiToNthDigitTest {

    public findPiToNthDigitTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("Testing \"Calculating pi to nth digit\"");
    }

    @Test
    public void checkDifferentDigitsCount() {
        int[] digits = {1, 5, 10, 50, 100, 1000};
        BigDecimal[] pi_exp = {
            new BigDecimal("3"),
            new BigDecimal("3.1415"),
            new BigDecimal("3.141592653"),
            new BigDecimal("3.1415926535897932384626433832795028841971693993751"),
            new BigDecimal("3.141592653589793238462643383279502884197169399375105820974944592307816406286208998628034825342117067"),
            new BigDecimal("3.141592653589793238462643383279502884197169399375105820974944592307816406286208998628034825342117067982148086513282306647093844609550582231725359408128481117450284102701938521105559644622948954930381964428810975665933446128475648233786783165271201909145648566923460348610454326648213393607260249141273724587006606315588174881520920962829254091715364367892590360011330530548820466521384146951941511609433057270365759591953092186117381932611793105118548074462379962749567351885752724891227938183011949129833673362440656643086021394946395224737190702179860943702770539217176293176752384674818467669405132000568127145263560827785771342757789609173637178721468440901224953430146549585371050792279689258923542019956112129021960864034418159813629774771309960518707211349999998372978049951059731732816096318595024459455346908302642522308253344685035261931188171010003137838752886587533208381420617177669147303598253490428755468731159562863882353787593751957781857780532171226806613001927876611195909216420198")
        };
        for (int i = 0; i < digits.length; i++) {
            System.out.println("find first " + digits[i] + " digits of pi");
            BigDecimal pi_act = Pi.findPiToNthDigit(digits[i]);
            assertEquals(pi_exp[i], pi_act);
        }
    }

    @Test
    public void checkWrongValues() {
        System.out.println("should throw an exception");
        try {
            System.out.println("when given argument lesser than 1");
            Pi.findPiToNthDigit(0);
            fail("expected IllegalArgumentException");
        } catch (IllegalArgumentException ex) {
        }
        try {
            System.out.println("when given argument greater than 1000");
            Pi.findPiToNthDigit(1001);
            fail("expected IllegalArgumentException");
        } catch (IllegalArgumentException ex) {
        }
    }

}
