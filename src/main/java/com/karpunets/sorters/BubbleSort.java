package com.karpunets.sorters;

import com.karpunets.sorters.utils.ArrayHelper;

/**
 * @author Karpunets
 * @since 09.12.2016
 */
public abstract class BubbleSort {

    public int[] sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int q = initialValue(array.length); checkLastValue(q, array.length, i); q = iteration(q)) {
                if (checkSwap(array[q], array[indexIntCheckSwap(q)])) {
                    ArrayHelper.swap(array, q, indexIntCheckSwap(q));
                }
            }
        }
        return array;
    }

    public abstract int initialValue(int arrayLength);
    public abstract boolean checkLastValue(int q, int arrayLength, int i);
    public abstract int iteration(int q);
    public abstract boolean checkSwap(int a, int b);
    public abstract int indexIntCheckSwap(int q);
}
