package chapter04;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CreateArray {
    public static void main(String[] args) {

        String[] arr = {"one", "two", "three", "four", "five"};
        Stream<String> stream = Arrays.stream(arr);
        Stream<String> stream2 = Arrays.stream(arr, 0, 2);

        Stream<String> stream1 = Arrays.asList(arr).stream();
        Stream<String> stream3 = Arrays.asList(arr).subList(0, 2).stream();

        Stream<String> stream4 = Stream.of(arr);
        Stream<String> stream5 = Stream.of("One", "Two", "Three", "Four");

        String[] strings = stream5.toArray(String[]::new);

        int[] ints = {1, 2, 4, 3, 5, 6};

        IntStream intStream = IntStream.of(ints);
        IntStream intStream1 = IntStream.range(0, ints.length);
    }
}
