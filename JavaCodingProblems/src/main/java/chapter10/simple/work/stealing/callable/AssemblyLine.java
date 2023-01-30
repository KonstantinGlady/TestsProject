package chapter10.simple.work.stealing.callable;

import java.util.Random;
import java.util.concurrent.*;
import java.util.logging.Logger;

public final class AssemblyLine {

    private AssemblyLine() {
        throw new AssertionError("Can not be instantiated");
    }

    private static final int MAX_PROD_TIME_MS = 5 * 1000;
    private static final int MAX_CONS_TIME_MS = 3 * 1000;
    private static final int TIMEOUT_MS = MAX_PROD_TIME_MS + MAX_CONS_TIME_MS + 1000;

    private static final Logger logger = Logger.getLogger(AssemblyLine.class.getName());
    private static final Random rnd = new Random();

    private static volatile boolean runningProducer;
    private static volatile boolean runningConsumer;

    private static ExecutorService producerService;
    private static ExecutorService consumerService;

    private static class Producer implements Callable {
        private final String bulb;

        public Producer(String bulb) {
            this.bulb = bulb;
        }

        @Override
        public String call() throws DefectBulbException, InterruptedException {

            if (runningProducer) {

                Thread.sleep(rnd.nextInt(MAX_PROD_TIME_MS));

                if (rnd.nextInt(100) < 5) {
                    throw new DefectBulbException("Defect " + bulb);
                } else {
                    logger.info(() -> "Checked " + bulb);
                }

                return bulb;
            }
            return "";
        }
    }

    private static class Consumer implements Runnable {
        private final String bulb;

        public Consumer(String bulb) {
            this.bulb = bulb;
        }

        @Override
        public void run() {

            if (runningConsumer) {

                try {
                    Thread.sleep(rnd.nextInt(MAX_CONS_TIME_MS));
                    logger.info("Packed " + bulb);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                    logger.severe(() -> "Exception " + ex);
                }
            }
        }
    }

    public static void startAssemblyLine() {

        if (runningProducer || runningConsumer) {
            logger.info("Assembly line is already running");
            return;
        }

        logger.info("Start assembly line");

        runningProducer = true;
        producerService = Executors.newSingleThreadExecutor();

        runningConsumer = true;
        consumerService = Executors.newSingleThreadExecutor();

        new Thread(() -> {
            automaticSystem();
        }).start();
    }

    @SuppressWarnings("unchecked")
    private static void automaticSystem() {

        while (runningProducer && runningConsumer) {

            String bulb = "bulb-" + rnd.nextInt(1000);
            Producer producer = new Producer(bulb);

            Future<String> futureBulb = producerService.submit(producer);

            try {
                String checkedBulb = futureBulb.get(MAX_PROD_TIME_MS + 1000, TimeUnit.MILLISECONDS);

                Consumer consumer = new Consumer(checkedBulb);

                if (runningConsumer) {
                    consumerService.execute(consumer);
                }

            } catch (ExecutionException ex) {
                logger.severe("Exception " + ex.getCause());
            } catch (InterruptedException ex) {
                logger.severe("Exception " + ex);
            } catch (TimeoutException ex) {
                logger.severe("Producer doesn't respect checking time");
            }
        }
    }

    public static void stopAssemblyLine() {
        boolean isProducerDown = shutdownProducer();
        boolean isConsumerDown = shutdownConsumer();

        if (!isConsumerDown || !isProducerDown) {
            logger.severe("Something abnormal happened during shutting down");
            System.exit(0);
        }

        logger.info("assembly line stopped");
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
            logger.severe("Exception " + ex);
        }
        return false;
    }

}
