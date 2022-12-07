package chapter08.practice4.functions;

import java.util.ArrayList;
import java.util.List;

public final class Filters {

    private Filters() {
        throw new AssertionError("can not be instantiated");
    }

    public static List<Melon> filterByType(List<Melon> melons, String type) {

        if (melons == null || type == null) throw new IllegalArgumentException("melons can not be null");
        if (melons.isEmpty() || type.isBlank()) return melons;

        List<Melon> result = new ArrayList<>();
        for (Melon m : melons) {
            if (m != null && type.equalsIgnoreCase(m.getType())) result.add(m);
        }

        return result;
    }

    public static List<Melon> filterByTypeAndWeight(List<Melon> melons, String type, int weight) {

        if (melons == null || type == null) throw new IllegalArgumentException("params can not be null");
        if (melons.isEmpty() || type.isBlank() || weight <= 0) return melons;

        List<Melon> result = new ArrayList<>();
        for (Melon m : melons) {
            if (m != null && type.equalsIgnoreCase(m.getType()) && weight == m.getWeight()) result.add(m);
        }

        return result;
    }

    public static List<Melon> filterMelon(List<Melon> melons, MelonPredicate p) {

        if (melons == null) throw new IllegalArgumentException("melons can not be null");
        if (melons.isEmpty()) return melons;

        List<Melon> result = new ArrayList<>();
        for (Melon m : melons) {
            if (m != null && p.test(m)) result.add(m);
        }

        return result;
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        if (list == null) throw new IllegalArgumentException("list can not be null");

        List<T> result = new ArrayList<>();
        for (T t : list) {
            if (t != null && p.test(t)) result.add(t);
        }

        return result;
    }
}
