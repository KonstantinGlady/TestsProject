package chapter10.simple.work.stealing.linked;

import java.util.Random;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class AssemblyLine {

    private AssemblyLine() {
        throw new AssertionError("Can not be instantiated");
    }

    private static final Logger logger = Logger.getLogger(AssemblyLine.class.getName());
    private static final int PROCESSORS = Runtime.getRuntime().availableProcessors();
    private static final int MAX_PROD_BULBS = 1_500_000;
    private static final Random rnd = new Random();
    private static final BlockingQueue<String> queue = new LinkedBlockingQueue<>();
    private static final Consumer consumer = new Consumer();
    private static long startTime;
    private static ExecutorService consumerService;

    private static class Consumer implements Runnable {

        @Override
        public void run() {

            String bulb = queue.poll();

          /*  if (bulb != null) {
                logger.info(() -> "Checked " + bulb + " by consumer " + Thread.currentThread().getName());
            }*/

            if (queue.isEmpty()) {
                logger.info(() -> "Checked all bulbs " + (System.currentTimeMillis() - startTime) + "ms");
                logger.info("This message above can be many times");

                System.exit(0);
            }
        }
    }

    public static void startAssemblyLine() {
        simulateProducer();
        startConsumers();
    }

    private static void startConsumers() {
        consumerService = Executors.newWorkStealingPool();

        logger.info(() -> "Consumers have team of " + PROCESSORS);

        int queueSize = queue.size();

        startTime = System.currentTimeMillis();

        for (int i = 0; i < queueSize; i++) {
            consumerService.execute(consumer);
        }

        consumerService.shutdown();
        try {
            consumerService.awaitTermination(Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
        } catch (InterruptedException ex) {
            logger.getLogger(AssemblyLine.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void simulateProducer() {
        logger.info(() -> "Simulated producers " + MAX_PROD_BULBS + " bulbs ");
        for (int i = 0; i < MAX_PROD_BULBS; i++) {
            queue.offer("bulb-" + rnd.nextInt(1000));
        }
    }
}
