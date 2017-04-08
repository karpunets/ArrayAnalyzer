package com.karpunets;

import com.karpunets.analyzer.SpeedTesting;
import com.karpunets.excel.Manager;
import com.karpunets.fillers.RandomGenerator;
import com.karpunets.sorters.BubbleDownSort;
import com.karpunets.sorters.BubbleSort;
import com.karpunets.sorters.BubbleUpSort;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Main {

    private static String nameFile = ".\\target\\generated-sources\\xlsx\\speedTesting.xlsx";

    public static void main(String[] args) {
        Manager.createXML(nameFile, (new SpeedTesting(20, 200, 10)).speedTestingSorts());
    }
}