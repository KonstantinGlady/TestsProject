package chapter08.execute.around.pattern;

import java.util.Scanner;

public class Maths {

    private Maths() {
        throw new IllegalStateException("utility class");
    }

    public static double getFirst(Scanner sc) {
        if (sc.hasNextDouble()) {
            return sc.nextDouble();
        }
        return Double.NaN;
    }

    public static double sumAll(Scanner sc) {
        double sum = 0.0d;
        while (sc.hasNextDouble()) {
            sum += sc.nextDouble();
        }
        return sum;
    }

}
