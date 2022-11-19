package chapter08.strategy.pattern2;

public final class Remover {

    private Remover() {
        throw new AssertionError("can not instantiated");
    }

    public static String remove(String s, RemoveStrategy strategy) {
        return strategy.execute(s);
    }
}
