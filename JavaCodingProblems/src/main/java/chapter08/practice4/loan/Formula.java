package chapter08.practice4.loan;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.function.Function;

public class Formula {

    private final Scanner sc;
    private double result;

    private Formula() throws IOException {
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
        if (sc.hasNextDouble()) result *= sc.nextDouble();
        return this;
    }

    public double result() {
        return result;
    }

    private void clear() {
        try (sc) {
            result = 0.0d;
        }
    }

    public static double compute(Function<Formula, Double> f) throws IOException {

        Formula formula = new Formula();
        double result = 0.0;

        try {
            result = f.apply(formula);
        } finally {
            formula.clear();
        }

        return result;
    }
}
