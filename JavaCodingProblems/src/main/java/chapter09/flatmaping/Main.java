package chapter09.flatmaping;

import chapter09.Melon;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.*;

public class Main {

    public static void main(String[] args) {

        List<Melon> melons = Arrays.asList(
                new Melon("Gac", 2000, Arrays.asList("Spider mites", "Melon Aphids")),
                new Melon("Hemi", 2300, Arrays.asList("Cucumber Beetles", "Squad bugs")),
                new Melon("HoneyDew", 1800, Arrays.asList("Spider mites", "Melon Aphids", "Squad bugs")),
                new Melon("Gac", 3400, Arrays.asList("Melon Aphids", "Cucumber Beetles"))
        );

        Map<String, Set<String>> result = melons.stream()
                .collect(groupingBy(Melon::getType,
                        flatMapping(m -> m.getPests().stream(), toSet())));
        result.forEach((k, v) -> System.out.println(k + " " + v));

        Map<Boolean, Set<String>> result2 = melons.stream()
                .collect(partitioningBy(m -> m.getWeight() > 2000,
                        flatMapping(m -> m.getPests().stream(), toSet())));
        result2.forEach((k, v) -> System.out.println(k + " " + v));
    }
}
