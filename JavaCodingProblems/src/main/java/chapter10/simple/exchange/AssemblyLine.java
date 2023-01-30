package chapter10.simple.exchange;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public final class AssemblyLine {

    private AssemblyLine() {
        throw new AssertionError("Can not be instantiated");
    }

    private static final int BUCKET_CAPACITY = 5;
    private static final int MAX_PROD_TIME_MS = 2 * 1000;
    private static final int MAX_CONS_TIME_MS = 5 * 1000;
    private static final int TIMEOUT_MS = (MAX_PROD_TIME_MS + MAX_CONS_TIME_MS) * BUCKET_CAPACITY;

    private static final Logger logger = Logger.getLogger(AssemblyLine.class.getName());
    private static final Random rnd = new Random();
    private static final Exchanger<List<String>> exchanger = new Exchanger<>();

    private static final Producer producer = new Producer();
    private static final Consumer consumer = new Consumer();

    private static volatile boolean runningProducer;
    private static volatile boolean runningConsumer;

    private static ExecutorService producerService;
    private static ExecutorService consumerService;

    private static class Producer implements Runnable {
        List<String> basket = new ArrayList<>(BUCKET_CAPACITY);

        @Override
        public void run() {

            while (runningProducer) {
                try {
                    for (int i = 0; i < BUCKET_CAPACITY; i++) {
                        String bulb = "bulb-" + rnd.nextInt(1000);
                        Thread.sleep(rnd.nextInt(MAX_PROD_TIME_MS));

                        basket.add(bulb);
                        logger.info(() -> "Checked and added to the bucket " + bulb);
                    }

                    logger.info("Producer: waiting changing for buckets");
                    basket = exchanger.exchange(basket);

                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                    logger.severe(() -> "Exception " + ex);
                    break;
                }
            }
        }
    }

    private static class Consumer implements Runnable {
        List<String> basket = new ArrayList<>();

        @Override
        public void run() {
            while (runningConsumer) {
                try {
                    logger.info("Consumer: waiting for bucket");
                    basket = exchanger.exchange(basket);
                    logger.info(()->"Consumer received the following bulbs " + basket);

                    for (String bulb : basket) {
                        if (bulb != null) {
                            Thread.sleep(rnd.nextInt(MAX_CONS_TIME_MS));
                            logger.info(() -> "Consumer: Packed " + bulb);
                        }
                    }

                    basket.clear();
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                    logger.severe(() -> "Exception " + ex);
                    break;
                }
            }
        }
    }

    public static void startAssemblyLine() {
        logger.info("Starting assembly line");

        if (runningProducer || runningConsumer) {
            logger.info("Assembly line is already running");
            return;
        }

        runningProducer = true;
        producerService = Executors.newSingleThreadExecutor();
        producerService.execute(producer);

        runningConsumer = true;
        consumerService = Executors.newSingleThreadExecutor();
        consumerService.execute(consumer);
    }

    public static void stopAssemblyLine() {
        logger.info("Stopping assembly line");

        boolean isProducerDown = shutdownProducer();
        boolean isConsumerDown = shutdownConsumer();

        if (isProducerDown || isConsumerDown) {
            logger.severe("Something abnormal happened during shutting down");
            System.exit(0);
        }
        logger.info("Assembly line stopped");
    }

    public static boolean shutdownProducer() {
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
