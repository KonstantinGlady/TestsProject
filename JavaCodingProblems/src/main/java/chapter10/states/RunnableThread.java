package chapter10.states;

public class RunnableThread {

    public void runnableThread() {

        Thread t = new Thread(() -> {
        });
        t.start();
        System.out.println("Thread state " + t.getState());
    }
}
