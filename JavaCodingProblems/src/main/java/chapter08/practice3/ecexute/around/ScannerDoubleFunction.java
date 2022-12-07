package chapter08.practice3.ecexute.around;

import java.io.IOException;
import java.util.Scanner;

public interface ScannerDoubleFunction {
    double readDouble(Scanner scanner) throws IOException;
}
