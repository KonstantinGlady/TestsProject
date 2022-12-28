package chapter09.teeing;

public class CountAndSum {

    private final long count;
    private final int sum;

    public CountAndSum(long count, int sum) {
        this.count = count;
        this.sum = sum;
    }

    public String toString() {
        return count + " " + sum;
    }
}
