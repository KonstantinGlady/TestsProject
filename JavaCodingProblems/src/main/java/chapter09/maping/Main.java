package chapter09.maping;

import chapter09.Melon;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Melon> melons = Arrays.asList(
                new Melon("Apollo", 2000),
                new Melon("Gac", 3000),
                new Melon("Cantaloupe", 2200),
                new Melon("Hemi", 1800),
                new Melon("Horned", 2500),
                new Melon("Horned", 3000)
        );

        Map<String, Set<Integer>> result = melons.stream()
                .collect(Collectors.groupingBy(Melon::getType,
                        Collectors.mapping(Melon::getWeight, Collectors.toCollection(TreeSet::new))));
        System.out.println(result);

        Map<Boolean, Set<String>> result2 = melons.stream()
                .collect(Collectors.partitioningBy(m -> m.getWeight() > 2000,
                        Collectors.mapping(Melon::getType, Collectors.toSet())));
        System.out.println(result2);
    }
}
