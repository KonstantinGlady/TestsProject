package chapter10.simple.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class BarberShop {
    private static final Logger logger = Logger.getLogger(BarberShop.class.getName());
    private final Semaphore seats;

    public BarberShop(int seatsCount) {
        this.seats = new Semaphore(seatsCount, true);
    }

    public boolean acquireSeat(int customerId) {
        logger.info(() -> "#Customer " + customerId + " is trying to get seat");

        try {
            boolean acquired = seats.tryAcquire(5 * 1000, TimeUnit.MILLISECONDS);

            if (!acquired) {
                logger.info(() -> "#Customer " + customerId + " has left barbershop");
                return false;
            }

            logger.info(() -> "#Customer " + customerId + " got a seat");

            return true;
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            logger.severe(() -> "Exception " + ex);
        }

        return false;
    }

    public void releaseSeat(int customerId) {
        logger.info(() -> "#Customer " + customerId + " has released seat");
        seats.release();
    }
}
