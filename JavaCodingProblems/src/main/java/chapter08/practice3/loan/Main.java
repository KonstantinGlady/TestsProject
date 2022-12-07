package chapter08.practice3.loan;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        double xPlusYMinusZ = Formula.compute(f -> f.add().add().minus().result());
        System.out.println(xPlusYMinusZ);
        double xMinusYMultiply = Formula.compute(f -> f.add().minus().multiplyWithSqrt().result());
        System.out.println(xMinusYMultiply);
    }
}
