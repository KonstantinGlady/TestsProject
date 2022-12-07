package chapter08.practice2.execute.around;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        double firstNum = Doubles.read(sc -> firstNumber(sc));
        System.out.println("first double " + firstNum);

        double sum = Doubles.read(sc -> sumAll(sc));
        System.out.println("sum " + sum);
    }

    public static double firstNumber(Scanner sc) {
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
