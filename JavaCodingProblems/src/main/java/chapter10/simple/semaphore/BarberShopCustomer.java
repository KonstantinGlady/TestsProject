package chapter10.simple.semaphore;

import java.util.Random;
import java.util.logging.Logger;

public class BarberShopCustomer implements Runnable {
    private static final Logger logger = Logger.getLogger(BarberShopCustomer.class.getName());
    private static final Random rnd = new Random();

    private final BarberShop barberShop;
    private final int customerId;

    public BarberShopCustomer(BarberShop barberShop, int customerId) {
        this.barberShop = barberShop;
        this.customerId = customerId;
    }

    @Override
    public void run() {
        boolean acquired = barberShop.acquireSeat(customerId);

        if (acquired) {
            try {
                Thread.sleep(rnd.nextInt(10 * 1000));
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
                logger.severe(() -> "Exception " + ex);
            } finally {
                barberShop.releaseSeat(customerId);
            }
        } else {
            Thread.currentThread().interrupt();
        }
    }
}
