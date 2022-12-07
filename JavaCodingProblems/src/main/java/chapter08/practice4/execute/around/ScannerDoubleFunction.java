package chapter08.practice4.execute.around;

import java.io.IOException;
import java.util.Scanner;

public interface ScannerDoubleFunction {
    double readDouble(Scanner sc) throws IOException;
}
