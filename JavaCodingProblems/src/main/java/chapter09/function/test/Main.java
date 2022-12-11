package chapter09.function.test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

    }

    public static List<String> replace(List<String> list, Replacer<String> r) {

        if (list == null || r == null) throw new IllegalArgumentException("params can not be null");

        List<String> result = new ArrayList<>();
        list.forEach(s -> result.add(r.replace(s)));

        return result;
    }

    @SuppressWarnings("unchecked")
    public static Function<String, String> reduce(Function<String, String>... functions) {

        return Stream.of(functions)
                .reduce(Function.identity(), Function::andThen);
    }
}
