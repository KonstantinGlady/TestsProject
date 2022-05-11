package bridge;

public class StackArray {
    private int[] items;
    private int size = -1;

    public StackArray() {
        this.items = new int[12];
    }

    public StackArray(int cells) {
        this.items = new int[cells];
    }

    public void push(int value) {
        if (!isFull()) {
            items[++size] = value;
        }
    }

    public int top() {
        if (isEmpty()) {
            return -1;
        }
        return items[size];
    }

    public int pop() {
        if (isEmpty()) {
            return -1;
        }
        return items[size--];
    }

    public boolean isEmpty() {
        return size == -1;
    }

    public boolean isFull() {
        return size == items.length - 1;
    }
}
