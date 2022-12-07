package chapter08.practice1.strategy;

public final class Remover {

    private Remover() {
        throw new AssertionError("can not instantiated");
    }

    public static String remove(String s, RemoveStrategy strategy) {

        if (s == null || strategy == null) throw new IllegalArgumentException("parameters can not be null");

        return strategy.execute(s);
    }
}
