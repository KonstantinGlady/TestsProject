package thread;

import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //thread(better work through Executors.newFixedThreadPool etc)
        Thread t1 = new Thread(() -> {
            System.out.println("thread 1");
        });

        Thread t2 = new Thread(() -> {
            System.out.println("Thread 2");
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        //Executor
        int x = 232;
        ExecutorService ex = Executors.newFixedThreadPool(2);
        Future<Integer> fu1 = ex.submit(() -> f(x));
        Future<Integer> fu2 = ex.submit(() -> g(x));
        System.out.println(fu1.get() + fu2.get());
        ex.shutdown();

        //scheduled executor
        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);

        work1();
        service.schedule(Main::work2, 3, TimeUnit.SECONDS);
        service.shutdown();

        //completable
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        CompletableFuture<Integer> a = new CompletableFuture<>();
        CompletableFuture<Integer> b = new CompletableFuture<>();
        CompletableFuture<Integer> c = a.thenCombine(b, (z, y) -> z + y);
        executorService.submit(() -> a.complete(f(x)));
        executorService.submit(() -> b.complete(g(x)));
        System.out.println("completable " + c.get());
        executorService.shutdown();
    }

    private static void work2() {
        System.out.println("work 2");
    }

    private static void work1() {
        System.out.println("work 1");
    }

    private static Integer g(int x) {
        return x + 5;
    }

    private static Integer f(int x) {
        return x * 10;
    }
}
