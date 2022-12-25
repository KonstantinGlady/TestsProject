package chapter09.find;

import chapter09.Melon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        List<Melon> melons = Arrays.asList(
                new Melon("Gac", 2000),
                new Melon("Appolo", 3000),
                new Melon("Hemi", 2500),
                new Melon("Cantaloupe", 1800)
        );
        String melon = melons.stream()
                .map(Melon::getType)
                .filter("Appollo"::equals)
                .findAny()
                .orElse("none");
        System.out.println(melon);

        boolean gacIncluded = melons.stream()
                .map(Melon::getType)
                .anyMatch("gac"::equalsIgnoreCase);
        System.out.println(gacIncluded);

        int max = melons.stream()
                .mapToInt(Melon::getWeight)
                .max()
                .orElse(-1);
        System.out.println("max " + max);

        double sum = melons.stream()
                .mapToDouble(Melon::getWeight)
                .sum();
        System.out.println("sum: " + sum);

        int reduce = melons.stream()
                .mapToInt(Melon::getWeight)
                .reduce(Integer::min)
                .orElse(-1);
        System.out.println(reduce);
    }
}
