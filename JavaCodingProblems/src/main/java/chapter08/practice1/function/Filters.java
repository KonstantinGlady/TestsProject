package chapter08.practice1.function;

import java.util.ArrayList;
import java.util.List;

public class Filters {

    private Filters() {
        throw new AssertionError("Can not instantiated.");
    }

    public static List<Melon> filterByType(List<Melon> melons, String type) {
        if (melons == null || type == null) throw new IllegalArgumentException("melons or type can not be null");

        if (melons.isEmpty() || type.isBlank()) return melons;

        List<Melon> result = new ArrayList<>();
        for (Melon m : melons) {
            if (m != null && m.getType().equalsIgnoreCase(type)) {
                result.add(m);
            }
        }
        return result;
    }

    public static List<Melon> filterByTypeAndWeight(List<Melon> melons, String type, int weight) {
        if (melons == null || type == null) {
            throw new IllegalArgumentException("mellons/type can not be null");
        }

        if (melons.isEmpty() || type.isBlank() || weight <= 0) {
            return melons;
        }

        List<Melon> result = new ArrayList<>();
        for (Melon m : melons) {
            if (m != null && m.getType().equalsIgnoreCase(type) && m.getWeight() == weight) {
                result.add(m);
            }
        }
        return result;
    }

    public static List<Melon> filterMelons(List<Melon> melons, MelonPredicate predicate) {
        if (melons == null) throw new IllegalArgumentException("melons can not be null");

        List<Melon> result = new ArrayList<>();
        for (Melon m : melons) {
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
