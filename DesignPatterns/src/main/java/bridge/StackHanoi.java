package bridge;

public class StackHanoi extends StackArray {
    private int totalRejected;

    public int getTotalRejected() {
        return totalRejected;
    }

    @Override
    public void push(int value) {
        if (!isEmpty() && value > top()) {
            totalRejected++;
        } else {
            super.push(value);
        }
    }
}
