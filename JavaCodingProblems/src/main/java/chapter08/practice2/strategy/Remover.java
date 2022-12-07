package chapter08.practice2.strategy;

public final class Remover {

    private Remover() {
        throw new AssertionError("can not instantiated");
    }

    public static String remove(String s, RemoveStrategy rs) {
        return rs.execute(s);
    }
}
