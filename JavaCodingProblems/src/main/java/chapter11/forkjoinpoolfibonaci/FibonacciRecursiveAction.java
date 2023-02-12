package chapter11.forkjoinpoolfibonaci;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.logging.Logger;

public class FibonacciRecursiveAction extends RecursiveAction {

    private static final Logger logger = Logger.getLogger(FibonacciRecursiveAction.class.getName());
    private static final long THRESHOLD = 5;

    private volatile long nr;

    public FibonacciRecursiveAction(long nr) {
        this.nr = nr;
    }

    @Override
    protected void compute() {

        final long n = nr;

        if (n <= THRESHOLD) {
            nr = fibonacci(n);
        } else {


            nr = ForkJoinTask.invokeAll(createSubtasks(n))
                    .stream()
                    .mapToLong(x -> x.getFibonacciNumber())
                    .sum();
        }
    }

    private List<FibonacciRecursiveAction> createSubtasks(long n) {

        List<FibonacciRecursiveAction> subTasks = new ArrayList<>();

        FibonacciRecursiveAction fibonacciMinusOne = new FibonacciRecursiveAction(n - 1);
        FibonacciRecursiveAction fibonacciMinusTwo = new FibonacciRecursiveAction(n - 2);

        subTasks.add(fibonacciMinusOne);
        subTasks.add(fibonacciMinusTwo);

        return subTasks;
    }

    private long fibonacci(long n) {
        logger.info(() -> "Number " + n + " Thread: " + Thread.currentThread().getName());

        if (n <= 1) {
            return n;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public long getFibonacciNumber() {
        return nr;
    }
}
