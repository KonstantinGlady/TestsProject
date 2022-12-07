package chapter08.practice4.strategy;

public class NumbersRemover implements RemoveStrategy {
    @Override
    public String apply(String s) {
        return s.replaceAll("\\d", "");
    }
}
