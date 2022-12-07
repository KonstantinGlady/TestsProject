package chapter08.practice3.strategy;

public class WhiteSpaceRemove implements RemoveStrategy {
    @Override
    public String execute(String s) {
        return s.replaceAll("\\s","");
    }
}
