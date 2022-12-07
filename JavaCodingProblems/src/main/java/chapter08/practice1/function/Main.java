package chapter08.practice1.function;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Melon> melons = Arrays.asList(
                new Melon("Gac", 1500, "USA"),
                new Melon("Watermelon", 2600, "China"),
                new Melon("Bailan", 5600, "Europe"),
                new Melon("Gac", 6000, "China"),
                new Melon("Watermelon", 3000, "China")
        );

        List<Melon> result = Filters.filterByType(melons, "gac");
        System.out.println(result);
        List<Melon> result2 = Filters.filterByTypeAndWeight(melons, "watermelon", 3000);
        System.out.println(result2);

        List<Melon> result3 = Filters.filterMelons(melons, new GacMelonPredicate());
        System.out.println(result3);

        List<Melon> result4 = Filters.filterMelons(melons, (Melon m) -> "usa".equalsIgnoreCase(m.getOrigin()));
        System.out.println(result4);

        List<Melon> result5 = Filters.filterMelons(melons, new MelonPredicate() {
            @Override
            public boolean test(Melon m) {
                return m.getWeight() > 3000;
            }
        });
        System.out.println(result5);

        Predicate<Melon> byOrigin = m -> m.getOrigin().equalsIgnoreCase("china");
        List<Melon> result6 = Filters.filter(melons, byOrigin);
        System.out.println(result6);

        List<Integer> numbers = List.of(2, 5, 8, 12, 22, 15);
        List<Integer> result7 = Filters.filter(numbers, n -> n > 8);
        System.out.println(result7);
    }
}
