package chapter11.forkjoinpoolfibonaci;

import java.util.concurrent.ForkJoinPool;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {

        System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tT] [%4$-7s] %5$s %n");

        int noOfProcessors = Runtime.getRuntime().availableProcessors();
        logger.info(() -> " We have processors " + noOfProcessors);

        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();

        int initialSize = forkJoinPool.getPoolSize();
        int parallelism = ForkJoinPool.getCommonPoolParallelism();

        logger.info(() -> " initial pool size " + initialSize);
        logger.info(() -> "parallelism " + parallelism);

        FibonacciRecursiveAction fibonacciRecursiveAction = new FibonacciRecursiveAction(12);
        forkJoinPool.invoke(fibonacciRecursiveAction);
        logger.info(() -> " fibonacci " + fibonacciRecursiveAction.getFibonacciNumber());

        int finalSize = forkJoinPool.getPoolSize();
        logger.info(() -> "final size of pool " + finalSize);

    }
}
