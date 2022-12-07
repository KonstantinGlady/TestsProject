package chapter08.practice4.functions;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Melon> melons = List.of(
                new Melon("Gac", 2000, "US"),
                new Melon("Hemi", 3000, "China"),
                new Melon("Bailan", 4000, "EU"),
                new Melon("Gac", 5000, "China")
        );

        List<Melon> gacMelons = Filters.filterByType(melons, "gac");
        System.out.println("gac melons " + gacMelons);

        List<Melon> bailan3000 = Filters.filterByTypeAndWeight(melons, "bailan", 3000);
        System.out.println("balian 3000 " + bailan3000);

        List<Melon> gacOOP = Filters.filterMelon(melons, new GacPredicate());
        System.out.println(gacOOP);

        List<Melon> fromChinaAnonymous = Filters.filterMelon(melons, new MelonPredicate() {
            @Override
            public boolean test(Melon m) {
                return "china".equalsIgnoreCase(m.getOrigin());
            }
        });
        System.out.println("from China " + fromChinaAnonymous);

        List<Melon> hemiLambda = Filters.filter(melons, m -> "hemi".equalsIgnoreCase(m.getType()));
        System.out.println("hemi " + hemiLambda);

        List<Integer> numbers = Arrays.asList(2, 4, 6, 8, 65, 34, 81);
        List<Integer> result = Filters.filter(numbers, n -> n > 8);
        System.out.println(result);
    }
}
