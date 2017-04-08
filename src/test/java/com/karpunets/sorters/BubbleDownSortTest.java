package com.karpunets.sorters;

import com.karpunets.fillers.RandomGenerator;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * @author Karpunets
 * @since 02.12.2016
 */
public class BubbleDownSortTest {

    private static BubbleDownSort tester;

    @BeforeClass
    public static void init() {
        tester = new BubbleDownSort();
    }

    @Test
    public void testSortWithSortArray() throws Exception {
        int[] array = RandomGenerator.getSortArray(10);
        int[] arrayAfterSort = new int[array.length];
        System.arraycopy(array, 0, arrayAfterSort, 0, arrayAfterSort.length);
        tester.sort(array);
        assertArrayEquals("Elements must be the same", array, arrayAfterSort);
    }

    @Test
    public void testImmutability() throws Exception {
//        int[] array = RandomGenerator.getArray(10);
        int[] array = {5, 5, 4, 4};
        int[] arrayAfterSort = new int[array.length];

        System.arraycopy(array, 0, arrayAfterSort, 0, arrayAfterSort.length);
        tester.sort(array);

        Set<Integer> indices = new HashSet<>();

        boolean immutable = false;
        for (int eAfterSort : arrayAfterSort) {
            for (int i = 0; i < array.length; i++) {
                if (eAfterSort == array[i] && !indices.contains(i)) {
                    indices.add(i);
                    immutable = true;
                    break;
                }
            }
            assertTrue(immutable);
            immutable = false;
        }
    }

    @Test
    public void testLength() throws Exception {
        int[] array = RandomGenerator.getArray(10);
        int lengthBeforeSort = array.length;
        tester.sort(array);
        assertEquals("Array length before sort must be equals array length after sort", lengthBeforeSort, array.length);

    }

    @Test(expected = NullPointerException.class)
    public void testNullPointerException() throws Exception {
        tester.sort(null);
    }

    @Test(timeout = 10000)
    public void testTimeOut() throws Exception {
        int[] array = RandomGenerator.getArray(10000);
        tester.sort(array);
    }

    @Test
    public void testCorrect() throws Exception {
        int[] array = RandomGenerator.getSortArray(10);
        tester.sort(array);
        boolean correct = true;
        int previous = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < previous) {
                correct = false;
                break;
            }
        }
        assertTrue("Method works wrong", correct);
    }


}