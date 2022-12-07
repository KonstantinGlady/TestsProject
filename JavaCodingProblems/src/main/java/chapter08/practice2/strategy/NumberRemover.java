package chapter08.practice2.strategy;

public class NumberRemover implements RemoveStrategy{
    @Override
    public String execute(String s) {
        return s.replaceAll("\\d","");
    }
}
