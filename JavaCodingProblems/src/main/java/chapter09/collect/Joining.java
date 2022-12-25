package chapter09.collect;

import chapter09.Melon;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Joining {

    public static void main(String[] args) {

        List<Melon> melons = Arrays.asList(
                new Melon("Apollo", 3000),
                new Melon("Gac", 1700),
                new Melon("Cantaloupe", 2200),
                new Melon("Hemi", 2500),
                new Melon("Horned", 3300)
        );

        String availableMelons = melons.stream()
                .map(Melon::getType)
                .distinct()
                .collect(Collectors.joining(", ", "Available melons: ", ". Thanks!"));

        System.out.println(availableMelons);

    }
}
