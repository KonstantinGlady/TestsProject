package chapter08.practice1.execute.around;

import java.io.IOException;
import java.util.Scanner;

public interface ScannerDoubleFunction {
    double readDouble(Scanner sc) throws IOException;
}
