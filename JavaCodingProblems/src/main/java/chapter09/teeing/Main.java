package chapter09.teeing;

import chapter09.Melon;

import java.util.*;

import static java.util.stream.Collectors.*;

import java.util.stream.Stream;

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

        CountAndSum cas = Stream.of(11, 22, 32, 15, 16, 7, 3, 9)
                .collect(teeing(
                        counting(),
                        summingInt(v -> v),
                        CountAndSum::new
                ));
        System.out.println(cas);

        WeightsAndSum was = melons.stream()
                .collect(teeing(
                        summingInt(Melon::getWeight),
                        mapping(m -> m.getWeight(), toList()),
                        WeightsAndSum::new
                ));
        System.out.println(was);

        MinAndMax mam = Stream.of(2, 5, 7, 8, 14, 15, 19)
                .collect(teeing(
                        minBy(Comparator.naturalOrder()),
                        maxBy(Comparator.naturalOrder()),
                        (Optional<Integer> a, Optional<Integer> b) ->
                                new MinAndMax(a.orElse(Integer.MIN_VALUE), b.orElse(Integer.MAX_VALUE))
                ));
        System.out.println(mam);
    }
}
