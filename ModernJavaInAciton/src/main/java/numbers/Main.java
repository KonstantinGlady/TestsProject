package numbers;

import java.util.function.IntSupplier;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        IntSupplier fis = new IntSupplier() {
            private int previous = 0;
            private int current = 1;

            @Override
            public int getAsInt() {
                int oldPrevious = this.previous;
                int nextValue = this.previous + this.current;
                this.previous = this.current;
                this.current = nextValue;
                return oldPrevious;
            }
        };
        //Fibonacci
        IntStream.generate(fis)
                .limit(10)
                .forEach(System.out::println);
    }
}
