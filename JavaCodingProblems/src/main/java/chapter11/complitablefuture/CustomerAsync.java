package chapter11.complitablefuture;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public final class CustomerAsync {
    private CustomerAsync() {
        throw new AssertionError("Can not be instantiated");
    }

    private static final Logger logger = Logger.getLogger(CustomerAsync.class.getName());

    public static void printOrder() throws InterruptedException, ExecutionException {

        CompletableFuture<Void> cfPrintOrder = CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                try {
                    logger.info(() -> "Print order " + Thread.currentThread().getName());
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        cfPrintOrder.get();
        logger.info("Customer order printed \n");
    }

    public static void fetchCustomerOrder() throws ExecutionException, InterruptedException {

        CompletableFuture<String> cfFetchCustomerOrder = CompletableFuture.supplyAsync(() -> {

            try {
                logger.info(" fetch customer order " + Thread.currentThread().getName());
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            return "Customer order #2121";
        });

        System.out.println("sum: " + cfFetchCustomerOrder.get());
        logger.info("Customer order fetched");
    }

    public static void fetchCustomerOrderExecutor() throws InterruptedException, ExecutionException {

        ExecutorService executor = Executors.newSingleThreadExecutor();

        CompletableFuture<String> cfCustomerOrderExecutor = CompletableFuture.supplyAsync(() -> {
            try {
                logger.info(() -> "fetched by " + Thread.currentThread().getName());
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            return "Customer order #2121";
        }, executor);

        String result = cfCustomerOrderExecutor.get();
        logger.info(() -> "sum: " + result);

        executor.shutdownNow();
    }

    public static void fetchInvoiceTotalSign() throws InterruptedException, ExecutionException {

        CompletableFuture<String> cfFetchInvoice = CompletableFuture.supplyAsync(() -> {

                    try {
                        logger.info(() -> "fetched by " + Thread.currentThread().getName());
                        Thread.sleep(500);
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }

                    return "Invoice # 2121";
                }).thenApply(o -> o + " total: 3333$")
                .thenApply(o -> o + " signed");

        String result = cfFetchInvoice.get();
        logger.info(() -> "result " + result + " \n");
    }

    public static void fetchOrderTotalException() throws InterruptedException, ExecutionException {

        //not necessary then use instead exceptionallyAsync just exceptionally
        ExecutorService executor = Executors.newSingleThreadExecutor();

        CompletableFuture<Integer> cfOrderTotal = CompletableFuture.supplyAsync(() -> {

            int surrogate = new Random().nextInt(1000);
            if (surrogate < 500) {
                throw new IllegalStateException(" Invoice service is not responding");
            }

            return 1000;
        }).exceptionallyAsync(ex -> {
            logger.severe(() -> "Exception: " + ex + Thread.currentThread().getName());

            return 0;
        }, executor);

        int result = cfOrderTotal.get();
        logger.info(() -> "Result " + result + "\n");
    }

    //if you put after exceptionally block with thenApply it will work even if exception accuse.
    //but you can make only 1 exceptionally block at the end, so it will break after fail
    public static void fetchInvoiceChainExceptions() throws InterruptedException, ExecutionException {

        CompletableFuture<String> cfFetchInvoice = CompletableFuture.supplyAsync(() -> {

            int surrogate = new Random().nextInt(1000);
            if (surrogate < 500) {
                throw new IllegalStateException("Invoice service is not response");
            }

            return "invoice #2121";
        }).exceptionally(ex -> {
            logger.severe("Exception " + ex + " by thread " + Thread.currentThread().getName());

            return "invoice-Exception";
        }).thenApply(o -> {

            int surrogate = new Random().nextInt(1000);
            if (surrogate < 500) {
                throw new IllegalStateException("Total service is not response");
            }

            return o + " 1000";
        }).exceptionally(ex -> {
            logger.severe(() -> "Exception " + ex + " Thread " + Thread.currentThread().getName());

            return "Total-Exception";
        }).thenApply(o -> {
            int surrogate = new Random().nextInt(1000);
            if (surrogate < 500) {
                throw new IllegalStateException("Sign service is not response");
            }

            return o + " sign";
        }).exceptionally(ex -> {
            logger.severe(() -> "Exception " + ex + " Thread " + Thread.currentThread().getName());

            return "Sign-Exception";
        });

        String result = cfFetchInvoice.get();
        System.out.println("Result " + result);
    }


}
