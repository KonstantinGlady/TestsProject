package chapter11.complitablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tT] [%4$-7s] %5$s %n");

        logger.info(("Print customer order"));
        CustomerAsync.printOrder();

        logger.info("Fetch order");
        CustomerAsync.fetchCustomerOrder();

        logger.info("fetch with executor");
        CustomerAsync.fetchCustomerOrderExecutor();

        logger.info("using thenApply");
        CustomerAsync.fetchInvoiceTotalSign();

        logger.info("exception base");
        CustomerAsync.fetchOrderTotalException();

        logger.info("Chain exceptions");
        CustomerAsync.fetchInvoiceChainExceptions();
    }
}
