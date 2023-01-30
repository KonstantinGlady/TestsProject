package chapter10.simple.work.stealing.callable;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tT] [%4$-7s] %5$s %n");

        AssemblyLine.startAssemblyLine();
        Thread.sleep(30 * 1000);
        AssemblyLine.stopAssemblyLine();
    }
}
