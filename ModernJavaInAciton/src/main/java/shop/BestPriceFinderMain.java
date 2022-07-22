package shop;

import java.util.List;
import java.util.function.Supplier;

public class BestPriceFinderMain {

    private static BestPriceFinder bestPriceFinder = new BestPriceFinder();

    public static void main(String[] args) {

        execute("sequential", () -> bestPriceFinder.findPricesSequential("myPhoneS23"));
        execute("parallel", () -> bestPriceFinder.findPricesParallel("myPhoneS23"));
        execute("future", () -> bestPriceFinder.findPricesFuture("myPhoneS23"));
        bestPriceFinder.printPricesStream("myPhoneS23");
    }

    private static void execute(String msg, Supplier<List<String>> s) {
        long start = System.nanoTime();
        System.out.println(s.get());
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println(msg + " done in " + duration + " msecs");
    }
}
