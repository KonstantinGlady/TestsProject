package chapter10.simple.fixed.thread.pool.transfer;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tF %1$tT] [%4$-7s] %5$s %n");

        AssemblyLine.startAssemblyLine();
        Thread.sleep(20 * 1000);
        AssemblyLine.stopAssemblyLine();

        Thread.sleep(2000);

        System.out.println("Start assembly line again");

        AssemblyLine.startAssemblyLine();
        Thread.sleep(15 * 1000);
        AssemblyLine.stopAssemblyLine();
    }
}
