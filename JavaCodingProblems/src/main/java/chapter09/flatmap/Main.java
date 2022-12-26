package chapter09.flatmap;

import chapter09.Melon;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Melon[][] array = {
                {new Melon("Appolo", 2000), new Melon("Gac", 3000)},
                {new Melon("Hemi", 2200), new Melon("Gac", 2100)},
                {new Melon("Cantaloupe", 2800), new Melon("Hemi", 4000)}
        };

        List<Melon> result = Arrays.stream(array)
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(result);

        List<List<String>> list = List.of(
                List.of("Gac", "Cantaloupe"),
                List.of("Hemi", "Gac"),
                List.of("Cantaloupe", "Appolo")
        );

        List<String> result2 = list.stream()
                .flatMap(Collection::stream)
                .distinct()
                .collect(Collectors.toList());
        result2.forEach(System.out::println);
    }
}
