package chapter09.collector;

import chapter09.Melon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        List<Melon> melons = Arrays.asList(
                new Melon("Apollo", 2000),
                new Melon("Gac", 3000),
                new Melon("Cantaloupe", 2200),
                new Melon("Hemi", 1800),
                new Melon("Horned", 2500)
        );

        int sumInts = melons.stream()
                .collect(Collectors.summingInt(Melon::getWeight));
        System.out.println("sum: " + sumInts);

        double sumDouble = melons.stream()
                .collect(Collectors.summingDouble(v -> (double) v.getWeight() / 1000));
        System.out.println(sumDouble);

        double sumDouble2 = melons.stream()
                .collect(Collectors.reducing(0.0, m -> (double) m.getWeight() / 1000, (m1, m2) -> m1 + m2));
        System.out.println(sumDouble2);

        //average
        double average = melons.stream()
                .collect(Collectors.averagingInt(Melon::getWeight));
        System.out.println(average);

        //count
        long countMelons = melons.stream()
                .filter(m -> m.getWeight() > 2000)
                .count();
        System.out.println(countMelons);

        String str = "Lorem Ipsum is simply dummy text ...";
        long countStr = Stream.of(str)
                .map(w -> w.split("\\s+"))
                .flatMap(Arrays::stream)
                .filter(w -> w.trim().length() != 0)
                .count();
        System.out.println(countStr);

        long countMelons2 = melons.stream()
                .filter(m -> m.getWeight() > 2000)
                .collect(Collectors.counting());
        System.out.println(countMelons2);

        long countMelons3 = melons.stream()
                .filter(m -> m.getWeight() > 2000)
                .collect(Collectors.reducing(0L, m -> 1L, Long::sum));
        System.out.println("count3 " + countMelons3);


        Comparator<Melon> byWeight = Comparator.comparing(Melon::getWeight);
        Melon max = melons.stream()
                .collect(Collectors.maxBy(byWeight))
                .orElseThrow();
        System.out.println(max);

        IntSummaryStatistics summarizing = melons.stream()
                .collect(Collectors.summarizingInt(Melon::getWeight));
        System.out.println(summarizing);
        System.out.println(summarizing.getMax());
    }
}
