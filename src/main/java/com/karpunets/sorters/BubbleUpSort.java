package com.karpunets.sorters;

import com.karpunets.sorters.utils.ArrayHelper;

/**
 * @author Karpunets
 * @since 24.11.2016
 */

public class BubbleUpSort extends BubbleSort implements Sorter {

    @Override
    public int initialValue(int arrayLength) {
        return 0;
    }

    @Override
    public boolean checkLastValue(int q, int arrayLength, int i) {
        return q < arrayLength - i - 1;
    }

    @Override
    public int iteration(int q) {
        return ++q;
    }

    @Override
    public boolean checkSwap(int a, int b) {
        return a > b;
    }

    @Override
    public int indexIntCheckSwap(int q) {
        return q + 1;
    }
}
