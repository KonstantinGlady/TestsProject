package chapter09.teeing;

public class MinAndMax {

    private final int min;
    private final int max;

    public MinAndMax(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public String toString() {
        return min + " " + max;
    }
}
