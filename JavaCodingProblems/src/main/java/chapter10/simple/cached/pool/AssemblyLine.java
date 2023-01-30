package chapter10.simple.cached.pool;

import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

public final class AssemblyLine {

    private AssemblyLine() {
        throw new AssertionError("Can not be instantiated");
    }

    private static final int MAX_NUMBERS_OF_CONSUMERS = 50;
    private static final int MAX_QUEUE_SIZE_ALLOWED = 5;
    private static final int MONITOR_QUEUE_INITIAL_DELAY_MS = 5 * 1000;
    private static final int MONITOR_QUEUE_RATE_MS = 3 * 1000;
    private static final int EXTRA_TIME_MS = 4 * 1000;
    private static final int SLOW_DOWN_PRODUCER_MS = 20 * 1000;

    private static final int MAX_PROD_TIME_MS = 1 * 1000;
    private static final int MAX_CONS_TIME_MS = 10 * 1000;
    private static final int TIMEOUT_MS = MAX_PROD_TIME_MS + MAX_CONS_TIME_MS + 1000;

    private static final Logger logger = Logger.getLogger(AssemblyLine.class.getName());
    private static final Random rnd = new Random();
    private static final BlockingQueue<String> queue = new LinkedBlockingQueue<>();

    private static final ThreadGroup threadGroup = new ThreadGroup("consumer");
    private static final AtomicInteger nrOfConsumers = new AtomicInteger();

    private static volatile boolean runningProducer;
    private static volatile boolean runningConsumer;

    private static int extraProdTime;

    private static ExecutorService producerService;
    private static ExecutorService consumerService;

    private static ScheduledExecutorService monitorService;
    private static ScheduledExecutorService slowerdownService;

    private static final Producer producer = new Producer();
    private static final Consumer consumer = new Consumer();

    private static class Producer implements Runnable {
        @Override
        public void run() {
            while (runningProducer) {
                try {
                    String bulb = "bulb" + rnd.nextInt(1000);

                    Thread.sleep(rnd.nextInt(MAX_PROD_TIME_MS) + extraProdTime);

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
            while (runningConsumer && queue.size() > 0 || nrOfConsumers.get() == 1) {

                try {
                    String bulb = queue.poll(MAX_PROD_TIME_MS + extraProdTime, TimeUnit.MILLISECONDS);

                    if (bulb != null) {

                        Thread.sleep(rnd.nextInt(MAX_CONS_TIME_MS));
                        logger.info(() -> "Packed " + bulb + " by consumer " + Thread.currentThread().getName());
                    }

                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                    logger.severe(() -> "Exception " + ex);
                    break;
                }
            }

            nrOfConsumers.decrementAndGet();
            logger.warning(() -> "Current thread is going  back to the pool in 60 sec for now"
                    + Thread.currentThread().getName());
        }
    }

    public static void startAssemblyLine() {

        if (runningProducer || runningConsumer) {
            logger.info("Assembly line is already running");
            return;
        }

        logger.info("\n\nStart assembly line");
        logger.info(() -> "Remaining bulbs from " + queue + "\n\n");

        runningProducer = true;
        producerService = Executors.newSingleThreadExecutor();
        producerService.execute(producer);

        runningConsumer = true;
        consumerService = Executors.newCachedThreadPool((Runnable r) -> new Thread(threadGroup, r));
        nrOfConsumers.incrementAndGet();
        consumerService.execute(consumer);

        monitorQueueSize();
        slowdownProducer();
    }

    private static void monitorQueueSize() {
        monitorService = Executors.newSingleThreadScheduledExecutor();
        monitorService.scheduleAtFixedRate(() -> {
            if (queue.size() > MAX_QUEUE_SIZE_ALLOWED
                    && threadGroup.activeCount() < MAX_NUMBERS_OF_CONSUMERS) {

                nrOfConsumers.incrementAndGet();
                consumerService.execute(consumer);
                logger.warning("###Thread added consumer ");
            }

            logger.warning(() -> " queue " + queue.size() +
                    " thread " + threadGroup.activeCount() +
                    " consumer " + nrOfConsumers.get() +
                    " idle " + (threadGroup.activeCount() - nrOfConsumers.get()));
        }, MONITOR_QUEUE_INITIAL_DELAY_MS, MONITOR_QUEUE_RATE_MS, TimeUnit.MILLISECONDS);

    }

    private static void slowdownProducer() {
        slowerdownService = Executors.newSingleThreadScheduledExecutor();
        slowerdownService.schedule(() -> {
            extraProdTime = EXTRA_TIME_MS;
            logger.warning("slow down producer");
        }, SLOW_DOWN_PRODUCER_MS, TimeUnit.MILLISECONDS);
    }

    public static void stopAssemblyLine() {
        boolean isProducerDown = shutdownProducer();
        boolean isConsumerDown = shutdownConsumer();
        boolean isSchedulerDown = shutdownSchedulers();

        if (!isProducerDown || !isConsumerDown || !isSchedulerDown) {
            logger.severe("Something abnormal happened during stopping assembly line");
            System.exit(0);
        }

        logger.info("Assembly line was stopped");
    }

    private static boolean shutdownProducer() {
        runningProducer = false;
        return shutdownExecutor(producerService);
    }

    private static boolean shutdownConsumer() {
        runningConsumer = false;
        return shutdownExecutor(consumerService);
    }

    private static boolean shutdownSchedulers() {
        if (!runningProducer && !runningConsumer) {
            return shutdownExecutor(monitorService) && shutdownExecutor(slowerdownService);
        }

        return false;
    }

    private static boolean shutdownExecutor(ExecutorService executor) {
        executor.shutdown();
        try {
            if (executor.awaitTermination(TIMEOUT_MS + extraProdTime, TimeUnit.MILLISECONDS)) {
                executor.shutdownNow();

                return executor.awaitTermination(TIMEOUT_MS + extraProdTime, TimeUnit.MILLISECONDS);
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
