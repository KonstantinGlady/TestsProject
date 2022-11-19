package chapter08.strategy.pattern;

import chapter08.Melon;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Filter {

    public static List<Melon> byType(List<Melon> list, String type) {
        List<Melon> result = new ArrayList<>();
        for (Melon m : list) {
            if (m != null && type.equalsIgnoreCase(m.getType())) {
                result.add(m);
            }
        }
        return result;
    }

    public static List<Melon> byType(List<Melon> list, MelonPredicate predicate) {
        List<Melon> result = new ArrayList<>();
        for (Melon m : list) {
            if (m != null && predicate.test(m)) {
                result.add(m);
            }
        }
        return result;
    }

    public static <P> List<P> filter(List<P> list, Predicate<P> predicate) {
        List<P> result = new ArrayList<>();
        for (P p : list) {
            if (p != null && predicate.test(p)) {
                result.add(p);
            }
        }
        return result;
    }
}
