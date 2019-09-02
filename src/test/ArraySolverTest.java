package test;

import main.ArraySolver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArraySolverTest {
    private ArraySolver arraySolver;
    private final Double[] standardInputArray = new Double[]{10.0, 2.0, 14.0, 4.0, 7.0, 6.0};
    private final Double[] inputArrayWithNegatives = new Double[]{-10.0, -50.0, 20.0, 17.0, 80.0};
    private final Double[] inputArrayWithDecimals = new Double[]{3.0, 7.0, 4.1, 100.0, 41.2};
    private final Double[] inputArrayWithDecimalsAndNegatives = new Double[]{-3.9, 72.3, -7.1, -987.6, 4.2, 5.5, 90.1};

    @BeforeEach
    public void setUp() {
        arraySolver = new ArraySolver();
    }

    @Test
    public void solve_standardCase_returnsCorrectOutput() {
        double x = 5;
        int k = 3;
        List<Double> output = arraySolver.solve(standardInputArray, x, k);

        ArrayList<Double> expectedResult = new ArrayList<>(Arrays.asList(4.0, 6.0, 7.0));
        assertEquals(output, expectedResult);
    }

    @Test
    public void solve_negativeNumberInInputArray_returnsCorrectOutput() {
        double x = 5;
        int k = 3;
        List<Double> output = arraySolver.solve(inputArrayWithNegatives, x, k);

        ArrayList<Double> expectedResult = new ArrayList<>(Arrays.asList(-10.0, 17.0, 20.0));
        assertEquals(output, expectedResult);
    }

    @Test
    public void solve_negativeXInput_returnsCorrectOutput() {
        double x = -30;
        int k = 4;
        List<Double> output = arraySolver.solve(inputArrayWithNegatives, x, k);

        ArrayList<Double> expectedResult = new ArrayList<>(Arrays.asList(-50.0, -10.0, 17.0, 20.0));
        assertEquals(output, expectedResult);
    }

    @Test
    public void solve_decimalsInInputArray_returnsCorrectOutput() {
        double x = 2;
        int k = 2;
        List<Double> output = arraySolver.solve(inputArrayWithDecimals, x, k);

        ArrayList<Double> expectedResult = new ArrayList<>(Arrays.asList(3.0, 4.1));
        assertEquals(output, expectedResult);
    }

    @Test
    public void solve_decimalsInXInput_returnsCorrectOutput() {
        double x = 0.1;
        int k = 2;
        List<Double> output = arraySolver.solve(inputArrayWithDecimalsAndNegatives, x, k);

        ArrayList<Double> expectedResult = new ArrayList<>(Arrays.asList(-3.9, 4.2));
        assertEquals(output, expectedResult);
    }

    @Test
    public void solve_kIsGreaterThanOrEqualToInputArray_returnsInputArray() {
        double x = 1.1;
        int k = 200;
        List<Double> output = arraySolver.solve(inputArrayWithDecimalsAndNegatives, x, k);

        List<Double> expectedResult = Arrays.asList(-987.6, -7.1, -3.9, 4.2, 5.5, 72.3, 90.1);
        assertEquals(output, expectedResult);
    }

    @Test
    public void solve_negativeK_throwsIllegalArgumentException() {
        double x = 5;
        int k = -1;

        assertThrows(IllegalArgumentException.class,
                () -> arraySolver.solve(standardInputArray, x, k));
    }

    @Test
    public void solve_zeroK_throwsIllegalArgumentException() {
        double x = 5;
        int k = 0;

        assertThrows(IllegalArgumentException.class,
                () -> arraySolver.solve(standardInputArray, x, k));
    }
}