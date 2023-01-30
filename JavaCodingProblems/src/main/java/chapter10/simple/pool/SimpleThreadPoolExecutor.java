package chapter10.simple.pool;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class SimpleThreadPoolExecutor implements Runnable {

    private final int taskId;

    public SimpleThreadPoolExecutor(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            //log ex
        }

        System.out.println("Executing task " + Thread.currentThread().getName() + " " + taskId);
    }

    public static void main(String[] args) {

        BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();

        AtomicInteger counter = new AtomicInteger();
        ThreadFactory threadFactory = (Runnable r) -> {
            System.out.println("creating a new -Thread-Cool " + counter.incrementAndGet());
            return new Thread(r, "Thread-Cool " + counter.get());
        };

        RejectedExecutionHandler rejectedHandler = (Runnable r, ThreadPoolExecutor executor) -> {
            if (r instanceof SimpleThreadPoolExecutor) {
                SimpleThreadPoolExecutor task = (SimpleThreadPoolExecutor) r;
                System.out.println("rejected " + task.taskId);
            }
        };

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                10, 20, 1, TimeUnit.SECONDS, queue, threadFactory, rejectedHandler
        );

        for (int i = 0; i < 50; i++) {
            executor.execute(new SimpleThreadPoolExecutor(i));
        }

        executor.shutdown();

        try {
            executor.awaitTermination(Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
