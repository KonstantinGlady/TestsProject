package chapter10.simple.phaser;

import java.util.concurrent.Phaser;
import java.util.logging.Logger;

public class ServerInstance implements Runnable {
    private static final Logger logger = Logger.getLogger(ServerInstance.class.getName());
    private final Phaser phaser = new Phaser(1) {
        @Override
        protected boolean onAdvance(int phase, int registeredParties) {
            logger.warning(() -> "phase: " + phase +
                    " registered parties: " + registeredParties);

            return registeredParties == 0;
        }
    };

    @Override
    public void run() {

        long startingIn = System.currentTimeMillis();

        logger.info("Server is getting ready to start\n");

        logger.info("Starting the first three services... ");
        startFirstThreeServices();

        logger.info("Starting the next two services... ");
        startNextTwoServices();

        logger.info("final phase... ");
        finalCheckIn();

        logger.info(() -> "Server has started in: " + (System.currentTimeMillis() - startingIn) / 1000 + " sec");

        logger.warning(() -> "Phaser is terminated: " + phaser.isTerminated() +
                " registered parties " + phaser.getRegisteredParties());
    }

    private void startFirstThreeServices() {
        Thread service1 = new Thread(new ServerService(phaser, "HTTP listener"));
        Thread service2 = new Thread(new ServerService(phaser, "JMX"));
        Thread service3 = new Thread(new ServerService(phaser, "Connector"));

        service1.start();
        service2.start();
        service3.start();

        phaser.arriveAndAwaitAdvance();
    }

    private void startNextTwoServices() {
        Thread service4 = new Thread(new ServerService(phaser, "Virtual machine"));
        Thread service5 = new Thread(new ServerService(phaser, "ports"));

        service4.start();
        service5.start();

        phaser.arriveAndAwaitAdvance();
    }

    private void finalCheckIn() {
        try {
            logger.info("For preparation need 2 sec");
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            logger.severe(() -> "Exception " + ex);
        } finally {
            phaser.arriveAndDeregister();
        }
    }
}
