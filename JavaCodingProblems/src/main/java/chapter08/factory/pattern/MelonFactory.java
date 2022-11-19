package chapter08.factory.pattern;

import java.util.Map;
import java.util.function.Supplier;

public class MelonFactory {

    private static final Map<String, Supplier<Fruit>> MELONS = Map.of(
            "Gag", Gag::new,
            "Hemi", Hemi::new,
            "Cantaloupe", Canptaloupe::new
    );

    private static final TriFunction<String, Integer, String, Melon> MELON = Melon::new;

    private MelonFactory() {
        throw new AssertionError("Can not be instantiated");
    }

    //base
  /*  public static Fruit newInstance(Class<?> clazz) {
        switch (clazz.getSimpleName()) {
            case "Gag":
                return new Gag();
            case "Hemi":
                return new Hemi();
            case "Cantaloupe":
                return new Canptaloupe();
            default:
                throw new IllegalArgumentException("Invalid class argument " + clazz);
        }
    }*/

    //function
    public static Fruit newInstance(Class<?> clazz) {
        Supplier<Fruit> supplier = MELONS.get(clazz.getSimpleName());
        if (supplier == null) {
            throw new IllegalArgumentException("Invalid class parameter " + clazz);
        }
        return supplier.get();
    }

    public static Fruit newInstance(String name, int weight, String color) {
        return MELON.apply(name, weight, color);
    }
}
