package chapter08.practice2.strategy;

public class WhiteSpaceRemover implements RemoveStrategy{
    @Override
    public String execute(String s) {
        return s.replaceAll("\\s","");
    }
}
