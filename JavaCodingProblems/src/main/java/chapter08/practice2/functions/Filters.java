package chapter08.practice2.functions;

import java.util.ArrayList;
import java.util.List;

public final class Filters {

    private Filters() {
        throw new AssertionError("can not be instantiated");
    }

    public static List<Melon> filterByType(List<Melon> list, String type) {
        if (list == null) throw new IllegalArgumentException("list can not be null");

        if (list.isEmpty() || type.isBlank()) return list;

        List<Melon> result = new ArrayList<>();

        for (Melon m : list) {
            if (m != null && type.equalsIgnoreCase(m.getType())) result.add(m);
        }
        return result;
    }

    public static List<Melon> filterByTypeAndWeight(List<Melon> list, String type, int weight) {
        if (list == null || type == null) throw new IllegalArgumentException("list or type can not be null");
        if (type.isBlank() || weight <= 0 || type.isEmpty()) return list;

        List<Melon> result = new ArrayList<>();
        for (Melon m : list) {
            if (m != null && type.equalsIgnoreCase(m.getType()) && weight == m.getWeight()) result.add(m);
        }
        return result;
    }

    public static List<Melon> filterMelons(List<Melon> list, MelonPredicate predicate) {
        if (list == null) throw new IllegalArgumentException("list can not be null");

        List<Melon> result = new ArrayList<>();
        for (Melon m : list) {
            if (m != null && predicate.test(m)) result.add(m);
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
