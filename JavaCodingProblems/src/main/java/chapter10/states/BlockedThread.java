package chapter10.states;

public class BlockedThread {

    public void blockedThread() {

        Thread t1 = new Thread(new SyncCode());
        Thread t2 = new Thread(new SyncCode());

        t1.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }

        t2.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }

        System.out.println(t1.getName() + " " + t1.getState());
        System.out.println(t2.getName() + " " + t2.getState());

        System.exit(0);
    }

    private static class SyncCode implements Runnable {

        @Override
        public void run() {

            System.out.println(Thread.currentThread().getName() + " in run");
            syncMethod();
        }

        public static synchronized void syncMethod() {

            System.out.println(Thread.currentThread().getName() + " in syncMethod");
            while (true) {

            }
        }
    }
}
