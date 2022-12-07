package chapter08.practice1.factory;

import java.util.Map;
import java.util.function.Supplier;

public final class MelonFactory {

    private MelonFactory() {
        throw new AssertionError("can not instantiated");
    }

    private static final TriFunction<String, Integer, String, MelonFruit> MELON = MelonFruit::new;
    private static final Map<String, Supplier<Fruit>> MELONS = Map.of(
            "Gac", Gac::new, "Hemi", Hemi::new, "Cantaloupe", Cantaloupe::new);

    public static Fruit newInstance(String type, int weight, String origin) {
        return MELON.apply(type, weight, origin);
    }

    public static Fruit newInstance(Class<?> clazz) {

        Supplier<Fruit> supplier = MELONS.get(clazz.getSimpleName());

        if (supplier == null) throw new IllegalArgumentException("Invalid clazz argument " + clazz);
        return supplier.get();

    }
 /*   public static Fruit newInstance(Class<?> clazz) {

        switch (clazz.getSimpleName()) {
            case "Gac":
                return new Gac();
            case "Hemi":
                return new Hemi();
            case "Cantaloupe":
                return new Cantaloupe();
            default:
                throw new IllegalArgumentException("Invalid clazz argument " + clazz);
        }
    }*/
}
