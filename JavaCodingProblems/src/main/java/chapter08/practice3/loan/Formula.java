package chapter08.practice3.loan;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.function.Function;

public class Formula {

    private final Scanner sc;
    private double result;

    public Formula() throws IOException {
        sc = new Scanner(Path.of("JavaCodingProblems/double.txt"), StandardCharsets.UTF_8);
        result = 0.0d;
    }

    public Formula add() {
        if (sc.hasNextDouble()) result += sc.nextDouble();
        return this;
    }

    public Formula minus() {
        if (sc.hasNextDouble()) result -= sc.nextDouble();
        return this;
    }

    public Formula multiplyWithSqrt() {
        if (sc.hasNextDouble()) result *= Math.sqrt(sc.nextDouble());
        return this;
    }

    public double result() {
        return result;
    }

    private void close() {
        try (sc) {
            result = 0.0d;
        }
    }

    public static double compute(Function<Formula, Double> f) throws IOException {
        double result = 0.0d;
        Formula formula = new Formula();

        try {
            result = f.apply(formula);
        } finally {
            formula.close();
        }
        return result;
    }
}
