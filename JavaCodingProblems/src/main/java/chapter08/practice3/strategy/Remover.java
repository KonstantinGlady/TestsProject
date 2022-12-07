package chapter08.practice3.strategy;

public final class Remover {

    private Remover() {
        throw new AssertionError("can not be instantiated");
    }

    public static String remove(String s, RemoveStrategy rs) {
        if (s == null || rs == null) throw new IllegalArgumentException("s can not be null");
        return rs.execute(s);
    }
}
