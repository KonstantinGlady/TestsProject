package chapter08.practice1.execute.around;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        double singleDouble = Doubles.read(sc -> getFirst(sc));
        System.out.println(singleDouble);

        double sumAllDoubles = Doubles.read(sc -> sumAll(sc));
        System.out.println(sumAllDoubles);
    }

    public static double getFirst(Scanner sc) throws IOException {
        if (sc.hasNextDouble()) {
            return sc.nextDouble();
        }
        return Double.NaN;
    }

    public static double sumAll(Scanner sc) throws IOException {
        double sum = 0.0d;
        while (sc.hasNextDouble()) {
            sum += sc.nextDouble();
        }
        return sum;
    }
}
