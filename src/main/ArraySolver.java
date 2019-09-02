package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArraySolver {
    /**
     * Runtime for the solver method is less than k * inputArray.length (except where k = 1, since inputArray.length decreases with k increments.)
     * Runtime for the solver method is always less than inputArray.length squared (except where inputArray.length = 1)
     *
     * Worst case runtime for this solver method occurs when k is one less than inputArray.length. (Runtime approaches but never hits inputArray.length squared.)
     *
     * Best case runtime complexity for this solver is 1, where k is >= inputArray.length.
     */
    public List<Double> solve(Double[] inputArray, double x, int k) {
        validate(k);
        List<Double> resultArrayList = new ArrayList<>();
        if (k >= inputArray.length) {
            resultArrayList = Arrays.asList(inputArray);
        } else {
            for (int iteration = 0; iteration < k; iteration++) {
                Double lowestDistanceFromX = Math.abs(inputArray[0] - x);
                int bestIndex = 0;
                for (int i = 1; i < inputArray.length; i++) {
                    Double currentDistanceFromX = Math.abs(inputArray[i] - x);
                    if (currentDistanceFromX < lowestDistanceFromX) {
                        lowestDistanceFromX = currentDistanceFromX;
                        bestIndex = i;
                    }
                }

                resultArrayList.add(inputArray[bestIndex]);
                inputArray = removeIndexFromArray(inputArray, bestIndex);
            }
        }

        Collections.sort(resultArrayList);
        return resultArrayList;
    }

    private Double[] removeIndexFromArray(Double[] inputArray, int index) {
        ArrayList<Double> newValues = new ArrayList<>();
        for (int i = 0; i < inputArray.length; i++) {
            if (i != index) {
                newValues.add(inputArray[i]);
            }
        }

        return newValues.toArray(new Double[inputArray.length - 1]);
    }

    private void validate(int k) {
        if (k < 1) {
            throw new IllegalArgumentException("k must be a positive integer.");
        }
    }
}
