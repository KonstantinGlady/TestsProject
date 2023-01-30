package chapter10.simple.latches;

import java.util.concurrent.CountDownLatch;
import java.util.logging.Logger;

public class ServerInstance implements Runnable {

    private static final Logger logger = Logger.getLogger(ServerInstance.class.getName());

    private static final CountDownLatch latch = new CountDownLatch(3);

    @Override
    public void run() {
        logger.info("Starting server..");

        long starting = System.currentTimeMillis();

        Thread service1 = new Thread(new ServerService(latch, "HTTP Listener"));
        Thread service2 = new Thread(new ServerService(latch, "JMX"));
        Thread service3 = new Thread(new ServerService(latch, "Connectors"));

        service1.start();
        service2.start();
        service3.start();

        try {
            latch.await();
            logger.info(() -> "Server has successfully started in "
                    + (System.currentTimeMillis() - starting) / 1000 + " sec");
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            //log ex
        }
    }
}
