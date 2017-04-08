package com.karpunets.fillers;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Karpunets
 * @since 02.12.2016
 */
public class RandomGeneratorTest {

    private final static int ARRAY_LENGTH = 10;

    @Test
    public void getSortArray() throws Exception {
        int[] array = RandomGenerator.getSortArray(ARRAY_LENGTH);
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

    @Test
    public void getSortArrayWithRandomElement() throws Exception {
        int[] array = RandomGenerator.getSortArrayWithRandomElement(ARRAY_LENGTH);
        boolean correct = true;
        int previous = array[0];
        for (int i = 1; i < array.length - 1; i++) {
            if (array[i] < previous) {
                correct = false;
                break;
            }

        }
        assertTrue("Method works wrong", correct);

    }

    @Test
    public void getReverseSortArray() throws Exception {
        int[] array = RandomGenerator.getReverseSortArray(ARRAY_LENGTH);
        boolean correct = true;
        int previous = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > previous) {
                correct = false;
                break;
            }

        }
        assertTrue("Method works wrong", correct);
    }

}