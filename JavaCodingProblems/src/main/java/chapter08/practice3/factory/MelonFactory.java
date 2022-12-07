package chapter08.practice3.factory;

import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;

public final class MelonFactory {

    private MelonFactory() {
        throw new AssertionError("can not be instantiated");
    }

    private static final TriFunction<String, Integer, String, Melon> MELON = Melon::new;
    private static final Map<String, Supplier<Fruit>> MELONS = Map.of(
            "Gac", Gac::new,
            "Watermelon", Watermelon::new,
            "Cantaloupe", Cantaloupe::new
    );

    public static Fruit newInstance(String type, int weight, String origin) {
        return MELON.apply(type, weight, origin);
    }

    public static Fruit newInstance(Class<?> clazz) {
        Supplier<Fruit> supplier = MELONS.get(clazz.getSimpleName());

        if (supplier == null) throw new IllegalArgumentException("invalid class name " + clazz);

        return supplier.get();
    }

    //oop
/*    public static Fruit newInstance(Class<?> clazz) {
        switch (clazz.getSimpleName()) {
            case "Gac":
                return new Gac();
            case "Watermelon":
                return new Watermelon();
            case "Cantaloupe":
                return new Cantaloupe();
            default:
                throw new IllegalArgumentException("invalid class name" + clazz);
        }
    }*/
}
