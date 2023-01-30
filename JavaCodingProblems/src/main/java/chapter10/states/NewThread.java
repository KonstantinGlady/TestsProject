package chapter10.states;

public class NewThread {

    public void newThread() {
        Thread t = new Thread(() -> {
        });
        System.out.println("Thread state " + t.getState());
    }
}
