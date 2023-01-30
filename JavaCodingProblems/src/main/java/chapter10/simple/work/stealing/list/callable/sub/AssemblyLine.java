package chapter10.simple.work.stealing.list.callable.sub;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.logging.Logger;

public final class AssemblyLine {

    private AssemblyLine() {
        throw new AssertionError("Cannot be instantiated");
    }

    private static final Logger logger = Logger.getLogger(AssemblyLine.class.getName());
    private static final int MAX_PROD_BULBS = 100;
    private static final int PROCESSORS = Runtime.getRuntime().availableProcessors();
    private static final Random rnd = new Random();
    private static final BlockingQueue<String> queue = new LinkedBlockingQueue<>();
    private static Consumer consumer = new Consumer();
    private static ExecutorService consumerService;

    private static class Consumer implements Callable {
        @Override
        public Object call() throws InterruptedException {

            String bulb = queue.poll();

            Thread.sleep(100);

            if (bulb != null) {
                logger.info(() -> "Packed " + bulb + " by consumer " + Thread.currentThread().getName());

                return bulb;
            }

            return "";
        }
    }

    public static void startAssemblyLine() {
        simulateProducers();
        startConsumers();
    }

    @SuppressWarnings("unchecked")
    private static void startConsumers() {

        logger.info(() -> "We have " + PROCESSORS + " consumers");

        consumerService = Executors.newWorkStealingPool();

        int queueSize = queue.size();
        List<Future<String>> futures = new ArrayList<>();
        for (int i = 0; i < queueSize; i++) {
            futures.add(consumerService.submit(consumer));
        }

        try {
            for (Future<String> future : futures) {
                String bulb = future.get();
                logger.info("Future done " + bulb);
            }

            consumerService.shutdown();
            consumerService.awaitTermination(Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            logger.severe("Exception " + ex);
        } catch (ExecutionException ex) {
            logger.severe("Exception " + ex.getCause());
        }
    }

    private static void simulateProducers() {

        logger.info(() -> "Simulation of producers ");
        logger.info(() -> " created bulbds " + MAX_PROD_BULBS);

        for (int i = 0; i < MAX_PROD_BULBS; i++) {
            queue.offer("bulb-" + rnd.nextInt(1000));
        }
    }
}
