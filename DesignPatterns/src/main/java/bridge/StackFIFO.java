package bridge;

public class StackFIFO extends StackArray {
    private StackArray stack = new StackArray();

    @Override
    public int pop() {
        while (!isEmpty()) {
            stack.push(super.pop());
        }
        int ret = stack.pop();

        while (!stack.isEmpty()) {
            push(stack.pop());
        }
        return ret;
    }
}
