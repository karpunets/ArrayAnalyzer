package com.karpunets.sorters;

import com.karpunets.sorters.utils.ArrayHelper;

/**
 * @author Karpunets
 * @since 24.11.2016
 */

public class QuickSort implements Sorter {
    @Override
    public int[] sort(int[] array) {
        return sort(array, 0, array.length - 1);
    }

    private static int[] sort(int[] array, int first, int last) {
        if (first >= last)
            return array;

        int pivot = (last + first) / 2;
        int left = first, right = last;

        while (left < right) {
            while (left < pivot && array[left] <= array[pivot]) {
                left++;
            }
            while (right > pivot && array[right] >= array[pivot]) {
                right--;
            }
            if (left < right) {
                ArrayHelper.swap(array, left, right);
                pivot = left == pivot ? right : right == pivot ? left : pivot;
            }
        }
        sort(array, first, pivot);
        sort(array, pivot + 1, last);
        return array;
    }
}
