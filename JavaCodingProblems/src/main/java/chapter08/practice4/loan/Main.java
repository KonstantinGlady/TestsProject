package chapter08.practice4.loan;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        //x + y - z
        double xPlusYMinusZ = Formula.compute(sc -> sc.add().add().minus().result());
        System.out.println(xPlusYMinusZ);

        //x - y *sqrt(z)
        double xMinusYMultiplySqrt = Formula.compute(sc -> sc.add().minus().multiplyWithSqrt().result());
        System.out.println(xMinusYMultiplySqrt);
    }
}
