package com.gik.testsProject.gik.concur;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Thread t = new Thread(() -> {
            if (!Thread.currentThread().isInterrupted()) {// проверка флага interrupt
                System.out.println("b");
            }
            System.out.println("a");
        });
        t.start();
        t.interrupt();// меняет флаг interrupted можно обработать

        FutureTask<String> task = new FutureTask<>(() -> {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(5000);
            return "Java";
        });
        new Thread(task).start();
        System.out.println(task.get());

    }
}
