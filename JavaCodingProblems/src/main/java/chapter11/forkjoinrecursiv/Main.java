package chapter11.forkjoinrecursiv;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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

        logger.info(() -> " initial size of pool " + initialSize);
        logger.info(() -> " parallelism " + parallelism);

        Random rnd = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            list.add(1 + rnd.nextInt(10));
        }

        SumRecursiveTask sumRecursiveTask = new SumRecursiveTask(list);
        int sumAll = forkJoinPool.invoke(sumRecursiveTask);
        logger.info(() -> "sum: " + sumAll);

        int afterSize = forkJoinPool.getPoolSize();
        logger.info(() -> " after task size " + afterSize);
    }
}
