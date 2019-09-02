package main;

import java.util.List;

public class ArraySolver {
    public List<Double> solve(Double[] inputArray, double x, int k) {
        validate(k);
        return null;
    }

    private void validate(int k) {
        if(k<1) {
            throw new IllegalArgumentException("k must be a positive integer.");
        }
    }
}
