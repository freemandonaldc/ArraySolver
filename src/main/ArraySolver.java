package main;

import java.util.ArrayList;
import java.util.List;

public class ArraySolver {
    public List<Double> solve(Double[] inputArray, double x, int k) {
        validate(k);

        List<Double> resultArrayList = new ArrayList<>();

        for(int iteration = 0; iteration < k; iteration++) {
            Double lowestDistanceFromX = Math.abs(inputArray[0] - x);
            int bestIndex = 0;

            for (int i = 0; i < inputArray.length; i++) {
                Double currentDistanceFromX = Math.abs(inputArray[i] - x);
                if (currentDistanceFromX < lowestDistanceFromX) {
                    lowestDistanceFromX = currentDistanceFromX;
                    bestIndex = i;
                }
            }
            resultArrayList.add(inputArray[bestIndex]);
            inputArray = removeIndexFromArray(inputArray, bestIndex);
        }

        return resultArrayList;
    }

    private Double[] removeIndexFromArray(Double[] inputArray, int index) {
        ArrayList<Double> newValues = new ArrayList<>();
        for(int i=0; i<inputArray.length; i++) {
            if(i!=index) {
                newValues.add(inputArray[i]);
            }
        }

        return newValues.toArray(new Double[inputArray.length-1]);
    }

    private void validate(int k) {
        if(k<1) {
            throw new IllegalArgumentException("k must be a positive integer.");
        }
    }
}
