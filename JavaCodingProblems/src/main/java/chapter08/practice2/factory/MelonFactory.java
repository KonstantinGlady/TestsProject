package chapter08.practice2.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public final class MelonFactory {

    private MelonFactory() {
        throw new AssertionError("can not be instantiated");
    }

    private static Map<String, Supplier<Fruit>> MELONS = Map.of(
            "Gac", Gac::new,
            "Hemi", Hemi::new,
            "Cantaloupe", Cantaloupe::new
    );

    private static TriFunction<String, Integer, String, Fruit> MELON = Melon::new;

    public static Fruit newInstance(String type, int weight, String origin) {
        return MELON.apply(type, weight, origin);
    }

    public static Fruit newInstance(Class<?> clazz) {
        if (clazz == null) throw new IllegalArgumentException("invalid argument " + clazz);

        Supplier<Fruit> result = MELONS.get(clazz.getSimpleName());
        if (result != null) return result.get();
        throw new IllegalArgumentException("invalid argument " + clazz);
    }


    //oop
   /* public static Fruit newInstance(Class<?> clazz) {
        if (clazz == null) throw new IllegalArgumentException("clazz can not be null");

        switch (clazz.getSimpleName()) {
            case "Gac":
                return new Gac();
            case "Hemi":
                return new Hemi();
            case "Cantaloupe":
                return new Cantaloupe();
            default:
                throw new IllegalArgumentException("invalid clazz argument " + clazz);
        }
    }*/
}
