package chapter10.sync;

public class ClassCLL2 {

    public void method() {

        synchronized(ClassCLL2.class) {
            System.out.println("synchronized static block");
        }
    }
}
