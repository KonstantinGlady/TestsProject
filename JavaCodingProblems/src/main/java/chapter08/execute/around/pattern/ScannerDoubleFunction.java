package chapter08.execute.around.pattern;

import java.io.IOException;
import java.util.Scanner;

public interface ScannerDoubleFunction {
    double readDouble(Scanner sc) throws IOException;
}
