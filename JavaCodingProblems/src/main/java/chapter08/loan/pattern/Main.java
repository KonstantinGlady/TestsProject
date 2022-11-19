package chapter08.loan.pattern;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        double xPlusYMinusZ = Formula.compute(sc -> sc.add().add().minus().result());
        System.out.println(xPlusYMinusZ);

        double xMinusYMultiplySqrtZ = Formula.compute(sc -> sc.add().minus().multiplyWithSqrt().result());
        System.out.println(xMinusYMultiplySqrtZ);
    }
}
