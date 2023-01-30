package chapter10.simple.cyclic;

import java.util.concurrent.CyclicBarrier;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerInstance implements Runnable {

    private static final Logger logger = Logger.getLogger(ServerInstance.class.getName());

    private static final Runnable barrierAction = () -> {
        logger.info("Services are ready to start");
    };
    private static final CyclicBarrier barrier = new CyclicBarrier(3, barrierAction);

    @Override
    public void run() {

        logger.info("The server is getting ready to start");
        logger.info(() -> "Starting services\n");

        long starting = System.currentTimeMillis();

        Thread service1 = new Thread(new ServerService(barrier, "HTTP Listener"));
        Thread service2 = new Thread(new ServerService(barrier, "JMX"));
        Thread service3 = new Thread(new ServerService(barrier, "Connectors"));

        service1.start();
        service2.start();
        service3.start();

        try {
            service1.join();
            service2.join();
            service3.join();

            logger.info(() -> " Server has successfully started in " +
                    (System.currentTimeMillis() - starting) / 1000 + " sec");

        } catch (InterruptedException ex) {
            Logger.getLogger(ServerInstance.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
