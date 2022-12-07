package chapter08.practice4.decorator.oop;

public class BaseCake implements Cake{
    @Override
    public String decorate() {
        return "base cake ";
    }
}
