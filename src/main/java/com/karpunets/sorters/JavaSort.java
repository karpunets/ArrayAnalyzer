package com.karpunets.sorters;

import java.util.Arrays;

/**
 * @author Karpunets
 * @since 24.11.2016
 */

public class JavaSort implements Sorter {
    @Override
    public int[] sort(int[] array) {
        Arrays.sort(array);
        return array;
    }
}
