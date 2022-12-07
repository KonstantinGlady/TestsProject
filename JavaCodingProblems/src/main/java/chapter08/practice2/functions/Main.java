package chapter08.practice2.functions;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Melon> melons = Arrays.asList(
                new Melon("watermelon", 2200, "EU"),
                new Melon("Gac", 4000, "China"),
                new Melon("Bailan", 2800, "US"),
                new Melon("Gac", 5000, "China")
        );

        List<Melon> gacMelons = Filters.filterByType(melons, "gac");
        System.out.println("gac melons " + gacMelons);

        List<Melon> bailansMoreThen2800 = Filters.filterByTypeAndWeight(melons, "bailan", 2800);
        System.out.println("bailans more then 2800 " + bailansMoreThen2800);

        List<Melon> gacMelons2 = Filters.filterMelons(melons, new GacPredicate());
        System.out.println("gac melons " + gacMelons2);

        List<Melon> biggerThen4000 = Filters.filterMelons(melons, new HugePredicate());
        System.out.println("bigger then 4000 " + biggerThen4000);

        List<Melon> bailanMelons = Filters.filter(melons, new Predicate<Melon>() {
            @Override
            public boolean test(Melon melon) {
                return melon.getType().equalsIgnoreCase("bailan");
            }
        });
        System.out.println("bailans " + bailanMelons);

        List<Melon> chines = Filters.filter(melons, m -> "china".equalsIgnoreCase(m.getOrigin()));
        System.out.println("chines " + chines);

        List<Integer> numbers = Arrays.asList(6, 7, 2, 8, 9, 11, 32, 45);
        List<Integer> result = Filters.filter(numbers, n -> n > 8);
        System.out.println("bigger then 8 " + result);
    }
}
