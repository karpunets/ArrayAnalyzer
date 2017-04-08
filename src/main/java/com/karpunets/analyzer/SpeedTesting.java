package com.karpunets.analyzer;

import com.karpunets.analyzer.annotation.Filler;
import com.karpunets.analyzer.annotation.TestingAnnotationMethods;
import com.karpunets.fillers.RandomGenerator;
import com.karpunets.excel.DataTest;
import com.karpunets.sorters.Sorter;
import org.reflections.Reflections;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Set;

/**
 * Class SpeedTesting is is used for testing class sorters in package {@link com.karpunets.sorters}
 * and methods are in {@link com.karpunets.fillers.RandomGenerator}
 *
 * @author Karpunets
 * @since 24.11.2016
 */

public class SpeedTesting {

    private DataTest dataTest;
    private TestingAnnotationMethods testingAnnotationMethods;
    private ArrayList<Sorter> sorters = new ArrayList<>();

    private int minArrayLength;
    private int difference;
    private int repetition;

    /**
     * @param minArrayLength is the minimum dimension of the array
     * @param difference     is intended to increase the length of the array with each new test
     * @param repetition     numbers of test repetitions
     */
    public SpeedTesting(int minArrayLength, int difference, int repetition) {
        this.minArrayLength = minArrayLength;
        this.difference = difference;
        this.repetition = repetition;
    }

    /**
     * Constructor (other params are {@link SpeedTesting}).
     *
     * @param bound is values of arrays limit
     */
    public SpeedTesting(int minArrayLength, int difference, int repetition, int bound) {
        this(minArrayLength, difference, repetition);
        RandomGenerator.setBound(bound);
    }

    /**
     * @return object {@link DataTest} with information about testing.
     * through Reflections it creates only arrays that mark annotation {@link Filler}
     * and uses all classes that implement {@link Sorter}
     * @see DataTest
     */
    public DataTest speedTestingSorts() {
        dataTest = new DataTest();
        testingAnnotationMethods = new TestingAnnotationMethods(this, dataTest, minArrayLength, difference);
        dataTest.setMinArrayLength(minArrayLength);
        dataTest.setDifference(difference);
        dataTest.setRepetition(repetition);
        fillSorters();
        dataTest.setMeterage(new long[getNumberFillers()][sorters.size()][repetition]);
        dataTest.setTest(new String[getNumberFillers()][sorters.size()][repetition]);
        for (int i = 0; i < repetition; i++) {
            testingAnnotationMethods.parseFillers(i);
        }
        return dataTest;
    }


    private void fillSorters() {
        Set<Class<? extends Sorter>> sortClasses = (new Reflections(Sorter.class.getPackage())).getSubTypesOf(Sorter.class);
        for (Class sortClass : sortClasses) {
            dataTest.getNamesSortClasses().add(sortClass.getSimpleName());
            try {
                sorters.add((Sorter) sortClass.newInstance());
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    private int getNumberFillers() {
        int i = 0;
        for (Method methodRandomGenerator : RandomGenerator.class.getDeclaredMethods()) {
            for (Annotation ann : methodRandomGenerator.getDeclaredAnnotations()) {
                if (ann instanceof Filler) {
                    i++;
                }
            }
        }
        return i;
    }


    public void parseSorts(int[] array, int iteration, int iterationFollers) {
        int i = 0;
        for (Sorter sorter : sorters) {
            int[] copiesArray = new int[array.length];
            System.arraycopy(array, 0, copiesArray, 0, array.length);
            long timer = -System.nanoTime();
            sorter.sort(copiesArray);
            timer += System.nanoTime();
            dataTest.getTest()[iterationFollers][i][iteration % repetition] = sorter.getClass().getSimpleName() + (minArrayLength + difference * i);
            dataTest.getMeterage()[iterationFollers][i++][iteration % repetition] = timer;
        }

    }


}
