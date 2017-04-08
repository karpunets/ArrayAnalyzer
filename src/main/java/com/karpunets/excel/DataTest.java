package com.karpunets.excel;

import java.util.ArrayList;
import java.util.List;

/**
 * DataTest is Plain Old Java Object (pojo) for storage of test data.
 *
 * @author Karpunets
 * @since 24.11.2016
 */

public class DataTest {
    private List<String> namesSortClasses = new ArrayList<>();
    private List<String> namesFillers = new ArrayList<>();
    private long[][][] meterage;

    public String[][][] getTest() {
        return test;
    }

    public void setTest(String[][][] test) {
        this.test = test;
    }

    private String[][][] test;
    private int minArrayLength;
    private int difference;
    private int repetition;


    public List<String> getNamesSortClasses() {
        return namesSortClasses;
    }

    public List<String> getNamesFillers() {
        return namesFillers;
    }

    public long[][][] getMeterage() {
        return meterage;
    }

    public void setMeterage(long[][][] meterage) {
        this.meterage = meterage;
    }

    public int getMinArrayLength() {
        return minArrayLength;
    }

    public void setMinArrayLength(int minArrayLength) {
        this.minArrayLength = minArrayLength;
    }

    public int getDifference() {
        return difference;
    }

    public void setDifference(int difference) {
        this.difference = difference;
    }

    public int getRepetition() {
        return repetition;
    }

    public void setRepetition(int repetition) {
        this.repetition = repetition;
    }
}
