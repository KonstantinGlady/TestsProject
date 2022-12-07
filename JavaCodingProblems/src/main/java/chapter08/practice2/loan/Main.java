package chapter08.practice2.loan;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        double xPlusYminusZ = Formula.compute(sc -> sc.add().add().minus().result());
        System.out.println(xPlusYminusZ);

        double xMinusYMultiplySqrtZ = Formula.compute(sc -> sc.add().minus().multiplyWithSqrt().result());
        System.out.println(xMinusYMultiplySqrtZ);
    }
}
