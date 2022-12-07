package chapter08.practice3.functional;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Melon> melons = List.of(
                new Melon("Watermelon", 3000, "US"),
                new Melon("Baelone", 5000, "China"),
                new Melon("Gac", 2800, "EU"),
                new Melon("Gac", 3200, "China")
        );

        //base
        List<Melon> gacMelons = Filters.filterByType(melons, "gac");
        System.out.println("gac " + gacMelons);

        List<Melon> gacBiggerThen3000 = Filters.filterByTypeAndWeight(melons, "gac", 3200);
        System.out.println("gac bigger then 3000 " + gacBiggerThen3000);

        //oop
        List<Melon> baeloneMelons = Filters.filterMelon(melons, new BaelonePredicate());
        System.out.println("baelones " + baeloneMelons);

        //anonimous

        List<Melon> melonsFromChina = Filters.filterMelon(melons, new MelonPredicate() {
            @Override
            public boolean test(Melon m) {
                return "china".equalsIgnoreCase(m.getOrigin());
            }
        });
        System.out.println("from china " + melonsFromChina);

        //lambda
        List<Melon> gacMelons2 = Filters.filter(melons, m -> "gac".equalsIgnoreCase(m.getType()));
        System.out.println("gac " + gacMelons2);

        //numbers
        List<Integer> numbers = List.of(2, 4, 6, 8, 11, 23);
        List<Integer> result = Filters.filter(numbers, n -> n > 7);
        System.out.println("bigger then 7 " + result);
    }
}
