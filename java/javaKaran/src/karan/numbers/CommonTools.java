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
public class CommonTools {
    
    public static long[] longListToArray(ArrayList<Long> list) {
        long[] result = new long[list.size()];
        Iterator<Long> it = list.iterator();
        for (int i = 0; it.hasNext(); i++) {
            result[i] = it.next();
        }
        return result;
    }
    
    public static int[] intListToArray(ArrayList<Integer> list) {
        int[] result = new int[list.size()];
        Iterator<Integer> it = list.iterator();
        for (int i = 0; it.hasNext(); i++) {
            result[i] = it.next();
        }
        return result;
    }
    
}
