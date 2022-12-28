package chapter09.teeing;

import java.util.List;

public class WeightsAndSum {

    private final int sum;
    private final List<Integer> weights;

    public WeightsAndSum(int sum, List<Integer> weights) {
        this.sum = sum;
        this.weights = weights;
    }

    public String toString() {
        return sum + " " + weights;
    }
}
