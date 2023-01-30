package chapter10.simple.executor;

import java.util.concurrent.Executor;

public class SimpleExecutor implements Executor {
    @Override
    public void execute(Runnable r) {
        new Thread(r).start();
    }

    public static void main(String[] args) {

        SimpleExecutor se = new SimpleExecutor();
        se.execute(() -> System.out.println("simple executro"));
    }
}
