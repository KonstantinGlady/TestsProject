package chapter09.collect;

import chapter09.Melon;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        List<Melon> melons = Arrays.asList(
                new Melon("Gac", 3000),
                new Melon("Apollo", 2000),
                new Melon("Cantaloupe", 3200),
                new Melon("Hemi", 1800),
                new Melon("Gac", 2300)
        );

        Set<String> set = melons.stream()
                .map(Melon::getType)
                .collect(Collectors.toCollection(HashSet::new));//TreeSet etc.

        System.out.println(set);

        //IllegalArgumentException: 2 similar records
     /*   Map<String, Integer> map2 = melons.stream()
                .distinct()
                .collect(Collectors.toMap(Melon::getType, Melon::getWeight));

        map2.forEach((k, v) -> System.out.println(k + " " + v));*/

        //but this way work just fine
        Map<Integer, Integer> map = melons.stream()
                .distinct()
                .map(m -> Map.entry(
                        new Random().nextInt(Integer.MAX_VALUE), m.getWeight()
                )).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        map.forEach((k, v) -> System.out.println(k + " " + v));
        System.out.println("///");

        Map<String, Integer> map3 = melons.stream()
                .collect(Collectors.toMap(Melon::getType, Melon::getWeight,
                        (oldValue, newValue) -> newValue));

        map3.forEach((k, v) -> System.out.println(k + " " + v));
        System.out.println("///");

        Map<String, Integer> map4 = melons.stream()
                .collect(Collectors.toMap(Melon::getType, Melon::getWeight,
                        (oldValue, newValue) -> newValue,
                        LinkedHashMap::new));

        map4.forEach((k, v) -> System.out.println(k + " " + v));
        System.out.println("///");

        String str = "Lorem Ipsum is simply Ipsum Lorem not simply Ipsum";
        Map<String, Integer> map1 = Stream.of(str)
                .map(w -> w.split("\\s+"))
                .flatMap(Arrays::stream)
                .collect(Collectors.toMap(
                        String::toLowerCase, w -> 1, Integer::sum
                ));

        map1.forEach((k, v) -> System.out.println(k + " " + v));
    }
}
