package chapter08.practice4.strategy;

public class WhiteSpaceRemover implements RemoveStrategy {
    @Override
    public String apply(String s) {
        return s.replaceAll("\\s","");
    }
}
