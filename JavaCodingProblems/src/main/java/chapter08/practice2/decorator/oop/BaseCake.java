package chapter08.practice2.decorator.oop;

public class BaseCake implements Cake{
    @Override
    public String decorate() {
        return "base cake ";
    }
}
