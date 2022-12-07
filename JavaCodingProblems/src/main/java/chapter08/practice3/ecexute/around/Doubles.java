package chapter08.practice3.ecexute.around;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Scanner;

public final class Doubles {
    private Doubles() {
        throw new AssertionError("can not be instantiated");
    }

    public static double read(ScannerDoubleFunction sdf) throws IOException {
        if (sdf == null) throw new IllegalArgumentException("parameter can not be null");

        try (Scanner sc = new Scanner(Path.of("JavaCodingProblems/double.txt"), StandardCharsets.UTF_8)) {
            return sdf.readDouble(sc);
        }
    }
}
