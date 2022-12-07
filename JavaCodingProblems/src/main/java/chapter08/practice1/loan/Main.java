package chapter08.practice1.loan;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        //x + y - z
        double result = Formula.compute(sc -> sc.add().add().minus().result());
        System.out.println(result);

        //x - y * sqrt(z)

        double result2 = Formula.compute(sc -> sc.add().minus().multiplyWithSqrt().result());
        System.out.println(result2);
    }
}
