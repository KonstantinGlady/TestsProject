package chapter10.simple.work.stealing.chunks;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

public final class AssemblyLine {

    private AssemblyLine() {
        throw new AssertionError("Can not be instantiated ");
    }

    private static final Logger logger = Logger.getLogger(AssemblyLine.class.getName());

    private static final int PROCESSORS = Runtime.getRuntime().availableProcessors();
    private static final int MAX_PROD_BULBS = 15_000_000;
    private static final int CHUNKS_BULBS = 1_000_000;
    private static final Random rnd = new Random();
    private static final Queue<BlockingQueue<String>> chunks = new LinkedBlockingQueue<>();
    private static long startTime;
    private static ExecutorService consumerService;

    private static class Consumer implements Runnable {
        private final BlockingQueue<String> bulbs;
        private static final AtomicInteger countBulbs = new AtomicInteger();

        public Consumer(BlockingQueue<String> bulbs) {
            this.bulbs = bulbs;
        }

        @Override
        public void run() {
            while (!bulbs.isEmpty()) {

                String bulb = bulbs.poll();

                if (bulb != null) {
                    // logger.info(()-> "Packed " + bulb + " by consumer " + Thread.currentThread().getName());
                }
                countBulbs.incrementAndGet();

            }

            if (countBulbs.get() == MAX_PROD_BULBS) {
                logger.info(() -> "All bulbs checked " + (System.currentTimeMillis() - startTime) + " ms");
                logger.info("This message above can be more then once");

                System.exit(0);
            }
        }
    }

    public static void startAssemblyLine() {
        simulateProducers();
        startConsumers();
    }

    private static void startConsumers() {
        logger.info(() -> "Consumers team of " + PROCESSORS);
        logger.info(() -> "after split in chunks there is " + chunks.size() + " of " + CHUNKS_BULBS);

        consumerService = Executors.newWorkStealingPool();

        startTime = System.currentTimeMillis();
        while (!chunks.isEmpty()) {
            Consumer consumer = new Consumer(chunks.poll());
            consumerService.execute(consumer);
        }

        consumerService.shutdown();
        try {
            consumerService.awaitTermination(Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            logger.severe("Exception " + ex);
        }

    }

    @SuppressWarnings("unchecked")
    private static Queue<BlockingQueue<String>> simulateProducers() {

        logger.info("Simulation of producers started");
        logger.info(() -> "Created " + MAX_PROD_BULBS);

        int counter = 0;
        while (counter < MAX_PROD_BULBS) {

            BlockingQueue chunk = new LinkedBlockingQueue<>(CHUNKS_BULBS);
            for (int i = 0; i < CHUNKS_BULBS; i++) {
                chunk.offer("bulb-" + rnd.nextInt(1000));
            }

            chunks.offer(chunk);
            counter += CHUNKS_BULBS;
        }
        return chunks;
    }

}
