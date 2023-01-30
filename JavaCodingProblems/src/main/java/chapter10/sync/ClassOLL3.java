package chapter10.sync;

public class ClassOLL3 {

    //should be final. good practice
    private final Object lock = new Object();

    public void method() {

        synchronized (lock) {
            System.out.println("synchronized block");
        }
    }
}
