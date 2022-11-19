package chapter08.strategy.pattern;

import chapter08.Melon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        //base
        List<Melon> melons = new ArrayList<>(
                Arrays.asList(
                        new Melon("one", 1, "eur"),
                        new Melon("two", 2, "usa"),
                        new Melon("three", 3, "eur"),
                        new Melon("four", 4, "usa")
                ));

        List<Melon> result = Filter.byType(melons, "one");
        System.out.println(result);

        //interface implementation
        List<Melon> result2 = Filter.byType(melons, new OnePredicate());
        System.out.println(result2);

        //anonymous class
        List<Melon> result3 = Filter.byType(melons, new MelonPredicate() {
            @Override
            public boolean test(Melon melon) {
                return melon.getType().equalsIgnoreCase("one");
            }
        });
        System.out.println(result3);

        //lambda with own interface
        List<Melon> result4 = Filter.byType(melons, m -> "one".equalsIgnoreCase(m.getType()));
        System.out.println(result4);

        //lambda with standard interface
        Predicate<Melon> predicate = (Melon m) -> "one".equalsIgnoreCase(m.getType());
        List<Melon> result5 = Filter.filter(melons, predicate);
        System.out.println(result5);

        //lambda with standard interface func
        List<Melon> result6 = melons.stream()
                .filter(predicate)
                .collect(Collectors.toList());
        System.out.println(result6);
    }
}
