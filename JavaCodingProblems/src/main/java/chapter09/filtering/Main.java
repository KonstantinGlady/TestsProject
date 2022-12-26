package chapter09.filtering;

import chapter09.Melon;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Melon> melons = Arrays.asList(
                new Melon("Apollo", 2000),
                new Melon("Gac", 3000),
                new Melon("Cantaloupe", 2200),
                new Melon("Hemi", 1800),
                new Melon("Horned", 2500)
        );

        List<Melon> result = melons.stream()
                .filter(m -> m.getWeight() > 2000)
                .collect(Collectors.toList());
        System.out.println(result);

        Map<String, List<Melon>> result2 = melons.stream()
                .collect(Collectors.groupingBy(Melon::getType,
                        Collectors.filtering(m -> m.getWeight() > 2000, Collectors.toList())));
        System.out.println(result2);

        Map<Boolean, Set<Melon>> result3 = melons.stream()
                .collect(Collectors.partitioningBy(m -> m.getWeight() > 2000,
                        Collectors.filtering(m -> m.getType().equals("Hemi"), Collectors.toSet())));
        System.out.println(result3);

    }
}
