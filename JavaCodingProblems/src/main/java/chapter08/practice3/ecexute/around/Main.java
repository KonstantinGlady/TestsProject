package chapter08.practice3.ecexute.around;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        double first = Doubles.read(sc -> getFirst(sc));
        System.out.println("first number " + first);

        double sum = Doubles.read(Main::sumAll);
        System.out.println("sum " + sum);
    }

    public static double getFirst(Scanner sc) {
        if (sc.hasNextDouble()) {
            return sc.nextDouble();
        }
        return Double.NaN;
    }

    public static double sumAll(Scanner sc) {
        double sum = 0.0d;
        while (sc.hasNextDouble()) sum += sc.nextDouble();

        return sum;
    }
}
