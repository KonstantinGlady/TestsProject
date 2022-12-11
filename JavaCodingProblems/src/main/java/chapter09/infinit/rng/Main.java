package chapter09.infinit.rng;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        IntStream ints = new Random().ints(4, 100);

        List<Integer> result = ints.filter(n -> n % 2 == 0)
                .limit(20)
                .boxed()
                .collect(Collectors.toList());
        System.out.println(result);

        IntStream ints2 = new Random().ints(20, 48, 126);
        String s = ints2
                .mapToObj(n -> String.valueOf((char) n))
                .collect(Collectors.joining());
        System.out.println(s);

    }
}
