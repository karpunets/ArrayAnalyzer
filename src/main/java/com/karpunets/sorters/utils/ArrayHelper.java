package com.karpunets.sorters.utils;

/**
 * The class contains static methods that help sorters.
 *
 * @author Karpunets
 * @since 24.11.2016
 */

public class ArrayHelper {

    /**
     * Swaps the elements with index1 and index2 of the array.
     */
    public static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
