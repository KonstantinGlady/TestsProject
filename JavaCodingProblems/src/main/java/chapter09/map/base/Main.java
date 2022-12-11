package chapter09.map.base;

import chapter09.Melon;

import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Melon> melons = List.of(
                new Melon("Gac", 3000),
                new Melon("Appolo", 2000),
                new Melon("Hemi", 1500),
                new Melon("Gac", 2200)
        );

        List<String> nameOfMelons = melons.stream()
                .map(Melon::getType)
                .collect(Collectors.toList());
        nameOfMelons.forEach(System.out::println);

        List<Melon> melons2 = melons.stream()
                .map(m -> {
                    m.setWeight(m.getWeight() + 500);

                    return m;
                }).collect(Collectors.toList());
        melons2.forEach(System.out::println);
    }
}
