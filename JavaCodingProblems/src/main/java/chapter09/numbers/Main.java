package chapter09.numbers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Integer> ints = Arrays.asList(1, 2, -4, 0, 2, 3, 0, 8);

        List<Integer> result = ints.stream()
                .filter(n -> n != 0)
                .distinct()
                .skip(1)
                .limit(2)
                .sorted()
                .collect(Collectors.toList());
        System.out.println(result);
    }
}
