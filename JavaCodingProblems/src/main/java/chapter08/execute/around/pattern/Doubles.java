package chapter08.execute.around.pattern;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Scanner;

public class Doubles {

    private Doubles() { throw new IllegalStateException("Utility class");}
    public static double read(ScannerDoubleFunction sdf) throws IOException {
        try (Scanner sc = new Scanner(
                Path.of("JavaCodingProblems/double.txt"), StandardCharsets.UTF_8)) {
            return sdf.readDouble(sc);
        }
    }
}
