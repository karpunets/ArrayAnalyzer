package com.karpunets.sorters;

import java.util.Arrays;

/**
 * @author Karpunets
 * @since 24.11.2016
 */

public class MergeSort implements Sorter {
    @Override
    public int[] sort(int[] array) {
        if (array.length <= 1) {
            return array;
        }

        int[] firstPart = Arrays.copyOfRange(array, 0, array.length / 2);
        int[] secondPart = Arrays.copyOfRange(array, array.length / 2, array.length);

        sort(firstPart);
        sort(secondPart);

        int fistInt = 0;
        int secondInt = 0;

        while (fistInt < firstPart.length || secondInt < secondPart.length) {
            if (fistInt != firstPart.length
                    && (secondInt == secondPart.length || firstPart[fistInt] < secondPart[secondInt])) {
                array[fistInt + secondInt] = firstPart[fistInt];
                fistInt++;
            } else {
                array[fistInt + secondInt] = secondPart[secondInt];
                secondInt++;
            }
        }
        return array;
    }
}
