package chapter10.simple.fixed.thread.pool.concur;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public final class AssemblyLine {

    private AssemblyLine() {
        throw new AssertionError("Can not be instantiated");
    }

    private static final int PRODUCER = 3;
    private static final int CONSUMER = 2;
    private static final int MAX_PROD_TIME_MS = 2 * 1000;
    private static final int MAX_CONS_TIME_MS = 2 * 1000;
    private static final int TIMEOUT_MS = (MAX_PROD_TIME_MS + MAX_CONS_TIME_MS) * (PRODUCER + CONSUMER);

    private static final Logger logger = Logger.getLogger(AssemblyLine.class.getName());
    private static final Random rnd = new Random();
    private static final Queue<String> queue = new ConcurrentLinkedQueue<>();

    private static volatile boolean runningProducer;
    private static volatile boolean runningConsumer;
    private static final Producer producer = new Producer();
    private static final Consumer consumer = new Consumer();

    private static ExecutorService producerService;
    private static ExecutorService consumerService;

    private static class Producer implements Runnable {
        @Override
        public void run() {
            while (runningProducer) {
                try {
                    String bulb = "bulb-" + rnd.nextInt(1000);

                    Thread.sleep(MAX_PROD_TIME_MS);

                    queue.offer(bulb);

                    logger.info(() -> "Checked " + bulb + " by producer " +
                            Thread.currentThread().getName());

                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                    logger.severe(() -> "Exception " + ex);
                    break;
                }
            }
        }
    }

    private static class Consumer implements Runnable {
        @Override
        public void run() {
            while (runningConsumer) {
                try {
                    String bulb = queue.poll();

                    if (bulb != null) {

                        Thread.sleep(rnd.nextInt(MAX_CONS_TIME_MS));
                        logger.info(() -> "Packed " + bulb + " by consumer " +
                                Thread.currentThread().getName());
                    }

                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                    logger.severe(() -> "Exception " + ex);
                    break;
                }
            }
        }
    }

    public static void startAssemblyLine() {

        if (runningProducer || runningConsumer) {
            logger.info(() -> "Assembly line is already running");
            return;
        }

        logger.info("\n\nStarting assembly line");
        logger.info(() -> "bulbs from previous queue " + queue + "\n\n");

        runningProducer = true;
        producerService = Executors.newFixedThreadPool(PRODUCER);
        for (int i = 0; i < PRODUCER; i++) {
            producerService.execute(producer);
        }

        runningConsumer = true;
        consumerService = Executors.newFixedThreadPool(CONSUMER);
        for (int i = 0; i < CONSUMER; i++) {
            consumerService.execute(consumer);
        }
    }

    public static void stopAssemblyLine() {
        boolean isProducerDown = shutdownProducer();
        boolean isConsumerDown = shutdownConsumer();

        if (!isProducerDown || !isConsumerDown) {
            logger.severe("Something abnormal happen");
            System.exit(0);
        }
    }

    private static boolean shutdownProducer() {
        runningProducer = false;
        return shutdownExecutor(producerService);
    }

    private static boolean shutdownConsumer() {
        runningConsumer = false;
        return shutdownExecutor(producerService);
    }

    private static boolean shutdownExecutor(ExecutorService executor) {
        executor.shutdown();
        try {
            if (executor.awaitTermination(TIMEOUT_MS, TimeUnit.MILLISECONDS)) {
                executor.shutdownNow();
                return executor.awaitTermination(TIMEOUT_MS, TimeUnit.MILLISECONDS);
            }

            return true;
        } catch (InterruptedException ex) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
            logger.severe(() -> "Exception " + ex);
        }

        return false;
    }
}
