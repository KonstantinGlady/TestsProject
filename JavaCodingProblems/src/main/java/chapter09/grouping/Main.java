package chapter09.grouping;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static chapter09.grouping.Melon.Sugar.*;

public class Main {

    public static void main(String[] args) {

        List<Melon> melons = List.of(
                new Melon("Crenshaw", 2000),
                new Melon("Gac", 3000),
                new Melon("Hemi", 3200),
                new Melon("Apollo", 2500),
                new Melon("Horned", 3200),
                new Melon("Hemi", 1800),
                new Melon("Gac", 3400)
        );

        Map<String, List<Melon>> melonsList = melons.stream()
                .collect(Collectors.groupingBy(Melon::getType));
        melonsList.forEach((k, v) -> System.out.println(k + " " + v));

        Map<Integer, List<Melon>> melonsList2 = melons.stream()
                .collect(Collectors.groupingBy(Melon::getWeight));
        melonsList2.forEach((k, v) -> System.out.println(k + " " + v));


        System.out.println("Set gives unique values:");
        Map<String, Set<Melon>> result = melons.stream()
                .collect(Collectors.groupingBy(Melon::getType, Collectors.toSet()));
        result.forEach((k, v) -> System.out.println(k + " " + v));

        System.out.println("Tree map gives order:");
        Map<String, Set<Melon>> result2 = melons.stream()
                .collect(Collectors.groupingBy(Melon::getType, TreeMap::new, Collectors.toSet()));
        result2.forEach((k, v) -> System.out.println(k + " " + v));

        System.out.println("chunks of 10 pieces:");
        List<Integer> numbers = new ArrayList<>(100);
        final AtomicInteger count = new AtomicInteger();
        Collection<List<Integer>> result3 = numbers.stream()
                .collect(Collectors.groupingBy(c -> count.getAndIncrement() / 10))
                .values();

        System.out.println("mapping from Melon to String:");
        Map<String, Set<String>> mapOfStrings = melons.stream()
                .collect(Collectors.groupingBy(
                        Melon::getType,
                        Collectors.mapping(Melon::getType, Collectors.toSet())));
        mapOfStrings.forEach((k, v) -> System.out.println(k + " " + v));

        System.out.println("counting: ");
        Map<String, Long> countMelons = melons.stream()
                .collect(Collectors.groupingBy(Melon::getType, Collectors.counting()));
        countMelons.forEach((k, v) -> System.out.println(k + " " + v));

        System.out.println("min by Weight for different types. But it's Optional");
        Map<String, Optional<Melon>> min = melons.stream()
                .collect(Collectors.groupingBy(Melon::getType,
                        Collectors.minBy(Comparator.comparingInt(Melon::getWeight))));

        min.forEach((v, k) -> System.out.println(v + " " + k));

        System.out.println("max without Optional:");
        Map<String, Integer> max = melons.stream()
                .collect(Collectors.groupingBy(Melon::getType,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingInt(Melon::getWeight)),
                                m -> m.orElseThrow().getWeight()
                        )));
        max.forEach((k, v) -> System.out.println(k + " " + v));

        Map<String, Melon[]> arr = melons.stream()
                .collect(Collectors.groupingBy(Melon::getType,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                l -> l.toArray(Melon[]::new)
                        )));
        arr.forEach((k, v) -> System.out.println(k + " " + Arrays.toString(v)));

        //double groupingBy

        List<Melon> melons2 = Arrays.asList(
                new Melon("Hemi", 2000, LOW),
                new Melon("Gac", 2500, HIGH),
                new Melon("Gac", 3300, MEDIUM),
                new Melon("Apollo", 3300, HIGH),
                new Melon("Gac", 2200, HIGH)
        );

        System.out.println("double grouping");
        Map<Melon.Sugar, Map<Integer, Set<String>>> result5 = melons2.stream()
                .collect(Collectors.groupingBy(Melon::getSugar,
                        Collectors.groupingBy(Melon::getWeight,
                                TreeMap::new,
                                Collectors.mapping(Melon::getType, Collectors.toSet()))));
        result5.forEach((k, v) -> System.out.println(k + " " + v.toString()));

    }
}
