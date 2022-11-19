package chapter08.strategy.pattern2;

public class WhiteSpaceRemover implements RemoveStrategy {
    @Override
    public String execute(String s) {
        return s.replaceAll("\\s", "");
    }
}
