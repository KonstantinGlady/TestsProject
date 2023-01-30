package chapter10.simple.single.thread.executor.cuncur;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public final class AssemblyLine {

    private AssemblyLine() {
        throw new AssertionError("Can not instantiate");
    }

    private static final int MAX_PROD_TIME_MS = 1 * 1000;
    private static final int MAX_CONS_TIME_MS = 3 * 1000;
    private static final int TIMEOUT_MS = MAX_PROD_TIME_MS + MAX_CONS_TIME_MS + 1000;
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

                    logger.info(() -> "Checked " + bulb);

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
                        Thread.sleep(MAX_CONS_TIME_MS);
                        logger.info(() -> "Packed " + bulb);
                    }

                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                    logger.severe(() -> "Exception " + ex);
                    break;
                }
            }
        }
    }

    public static void startAssemblyLine(Queue<String> remainingQueue) {

        if (runningProducer || runningConsumer) {
            logger.info(() -> "Assembly is already running");
            return;
        }

        logger.info("\n\nStarting assembly line");
        logger.info(() -> "Bulb taking from previous queue " + queue + "\n\n");

        queue.addAll(remainingQueue);

        runningProducer = true;
        producerService = Executors.newSingleThreadExecutor();
        producerService.execute(producer);

        runningConsumer = true;
        consumerService = Executors.newSingleThreadExecutor();
        consumerService.execute(consumer);
    }

    public static Queue<String> stopAssemblyLine() {
        logger.info(() -> "Stopping assembly line");

        boolean isProducerDown = shutdownProducer();
        boolean isConsumerDown = shutdownConsumer();

        if (!isProducerDown || !isConsumerDown) {
            logger.info(() -> "stopping goes wrong");
            System.exit(0);
        }

        logger.info(() -> "Assembly line stopped");

        return queue;
    }

    private static boolean shutdownProducer() {

        runningProducer = false;
        return shutdownExecutor(producerService);
    }

    private static boolean shutdownConsumer() {

        runningConsumer = false;
        return shutdownExecutor(consumerService);
    }

    private static boolean shutdownExecutor(ExecutorService executor) {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(TIMEOUT_MS, TimeUnit.MILLISECONDS)) {
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
