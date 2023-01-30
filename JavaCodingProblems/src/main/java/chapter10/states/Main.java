package chapter10.states;

public class Main {

    public static void main(String[] args) {

        System.out.println("state NEW");
        NewThread t = new NewThread();
        t.newThread();

        System.out.println("state RUNNABLE");
        RunnableThread r = new RunnableThread();
        r.runnableThread();

        System.out.println("state BLOCKED");
        BlockedThread bt = new BlockedThread();
        bt.blockedThread();
    }
}
