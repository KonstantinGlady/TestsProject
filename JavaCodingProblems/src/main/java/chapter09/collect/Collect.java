package chapter09.collect;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.stream.Stream;

public class Collect {

    public static void main(String[] args) {

        List<String> list = Stream.of("One", "Two", "Three")
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        System.out.println(list);

        Deque<String> deque = Stream.of("One", "Two", "Three")
                .collect(ArrayDeque::new, ArrayDeque::add, ArrayDeque::addAll);
        System.out.println(deque);

        String str = Stream.of("One", "Two", "Three")
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
        System.out.println(str);
    }
}
