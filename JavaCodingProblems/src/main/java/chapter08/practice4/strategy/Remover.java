package chapter08.practice4.strategy;

public final class Remover {

    private Remover() {
        throw new AssertionError("can not be instantiated");
    }

    public static String remove(String str, RemoveStrategy sr) {

        if (str == null || sr == null) throw new IllegalArgumentException("params can not be null");

        return sr.apply(str);
    }
}
