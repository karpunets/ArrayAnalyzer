package com.karpunets.analyzer.annotation;

import com.karpunets.analyzer.SpeedTesting;
import com.karpunets.excel.DataTest;
import com.karpunets.fillers.RandomGenerator;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Karpunets
 * @since 09.12.2016
 */
public class TestingAnnotationMethods {

    private SpeedTesting speedTesting;
    private DataTest dataTest;
    private int minArrayLength;
    private int difference;

    public TestingAnnotationMethods(SpeedTesting speedTesting, DataTest dataTest, int minArrayLength, int difference) {
        this.speedTesting = speedTesting;
        this.dataTest = dataTest;
        this.minArrayLength = minArrayLength;
        this.difference = difference;
    }

    public void parseFillers(int iteration) {
        boolean mustTesting = false;
        int i = 0;

        for (Method methodRandomGenerator : RandomGenerator.class.getDeclaredMethods()) {
            for (Annotation ann : methodRandomGenerator.getDeclaredAnnotations()) {
                if (ann instanceof Filler) {
                    mustTesting = true;
                    break;
                }
            }
            if (mustTesting) {
                if (iteration == 0) {
                    dataTest.getNamesFillers().add(methodRandomGenerator.getName());
                }
                try {
                    speedTesting.parseSorts((int[]) methodRandomGenerator.invoke(RandomGenerator.class, minArrayLength + difference * iteration), iteration, i++);
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                    e.printStackTrace();
                }
                mustTesting = false;
            }
        }
    }

}
