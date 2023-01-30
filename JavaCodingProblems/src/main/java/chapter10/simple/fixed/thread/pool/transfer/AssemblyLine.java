package chapter10.simple.fixed.thread.pool.transfer;

import java.util.Random;
import java.util.concurrent.*;
import java.util.logging.Logger;

public final class AssemblyLine {

    private AssemblyLine() {
        throw new AssertionError("Can not be instantiated");
    }

    private static final int PRODUCER = 3;
    private static final int CONSUMER = 2;
    private static final int MAX_PROD_TIME_MS = 2 * 1000;
    private static final int MAX_CONS_TIME_MS = 3 * 1000;
    private static final int TIMEOUT_MS = ((PRODUCER * MAX_CONS_TIME_MS + 1) / CONSUMER) + 1000;

    private static final Logger logger = Logger.getLogger(AssemblyLine.class.getName());
    private static final Random rnd = new Random();
    private static final TransferQueue<String> queue = new LinkedTransferQueue<>();

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
                    String bulb = "bulb " + rnd.nextInt(1000);

                    Thread.sleep(rnd.nextInt(MAX_PROD_TIME_MS));

                    boolean transferred = queue.tryTransfer(bulb, TIMEOUT_MS, TimeUnit.MILLISECONDS);

                    if (transferred) {
                        logger.info(() -> "Checked " + bulb + " by producer " +
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

    private static class Consumer implements Runnable {
        @Override
        public void run() {
            while (runningConsumer) {
                try {
                    String bulb = queue.poll(MAX_PROD_TIME_MS, TimeUnit.MILLISECONDS);

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
        logger.info(() -> "Bulbs taken from previous queue \n" + queue + "\n\n");

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
        logger.info(() -> "Stopping assembly line");

        boolean isProducerDown = shutdownProducer();
        boolean isConsumerDown = shutdownConsumer();

        if (!isProducerDown || !isConsumerDown) {
            logger.info(() -> "Something abnormal happened during shutting down");
            System.exit(0);
        }

        logger.info(()-> "Assembly line shutted down");

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
            if (!executor.awaitTermination(TIMEOUT_MS * 2, TimeUnit.MILLISECONDS)) {
                executor.shutdownNow();

                return executor.awaitTermination(TIMEOUT_MS * 2, TimeUnit.MILLISECONDS);
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
