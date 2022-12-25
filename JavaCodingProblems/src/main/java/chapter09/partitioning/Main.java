package chapter09.partitioning;

import chapter09.Melon;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class Main {

    public static void main(String[] args) {

        List<Melon> melons = Arrays.asList(
                new Melon("Apollo", 2000),
                new Melon("Gac", 3000),
                new Melon("Cantaloupe", 2200),
                new Melon("Hemi", 1800),
                new Melon("Horned", 2500)
        );

        Map<Boolean, List<Melon>> biggerThen2000 = melons.stream()
                .collect(partitioningBy(m -> m.getWeight() > 2000));
        biggerThen2000.forEach((k, v) -> System.out.println(k + " " + v));

        Map<Boolean, Long> countMelons = melons.stream()
                .distinct()
                .collect(Collectors.partitioningBy(m -> m.getWeight() > 2000, counting()));
        System.out.println(countMelons);

        Map<Boolean, Melon> result = melons.stream()
                .distinct()
                .collect(partitioningBy(m -> m.getWeight() > 2000,
                        collectingAndThen(
                                Collectors.maxBy(Comparator.comparingInt(Melon::getWeight)), Optional::get)));
        result.forEach((k, v) -> System.out.println(k + " " + v));
    }
}
