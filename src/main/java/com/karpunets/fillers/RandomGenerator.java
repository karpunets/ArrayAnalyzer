package com.karpunets.fillers;

import com.karpunets.analyzer.annotation.Filler;

import java.util.Arrays;
import java.util.Random;

/**
 * Class RandomGenerator includes methods that return different <code>int[]</code>.
 * They must have annotation {@link Filler}.
 *
 * @author Karpunets
 * @since 24.11.2016
 */

public class RandomGenerator {

    private static Random random = new Random();
    private static int bound = 100;

    /**
     * @param newBound is values of arrays limit.
     */
    public static void setBound(int newBound) {
        bound = newBound;
    }

    /**
     * @return array with random values.
     */
    @Filler
    public static int[] getArray(int length) {
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(bound);
        }
        return array;
    }

    @Filler
    public static int[] getSortArray(int length) {
        int[] array = getArray(length);
        Arrays.sort(array);
        return array;
    }

    @Filler
    public static int[] getSortArrayWithRandomElement(int length) {
        int[] array = Arrays.copyOf(getSortArray(length - 1), length);
        array[length - 1] = random.nextInt(bound);

        return array;
    }

    @Filler
    public static int[] getReverseSortArray(int length) {
        int[] array = getSortArray(length);
        int[] reverseArray = new int[length];
        for (int i = 0; i < array.length; i++) {
            reverseArray[i] = array[length - i - 1];
        }
        return reverseArray;
    }

}
