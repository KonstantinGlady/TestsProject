package chapter08.execute.around.pattern;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        //base
        try (Scanner scanner = new Scanner(
                Path.of("JavaCodingProblems/double.txt"), StandardCharsets.UTF_8)) {
            if (scanner.hasNextDouble()) {
                System.out.println(scanner.nextDouble());
            }
        }

        try (Scanner scanner = new Scanner(
                Path.of("JavaCodingProblems/double.txt"), StandardCharsets.UTF_8
        )) {
            while (scanner.hasNextDouble()) {
                System.out.println(scanner.nextDouble());
            }
        }
        //lambda execute around
        double fist = Doubles.read((Scanner sc) -> Maths.getFirst(sc));
        System.out.println("first " + fist);
        double sumAll = Doubles.read(Maths::sumAll);
        System.out.println("sum " + sumAll);

    }

}
