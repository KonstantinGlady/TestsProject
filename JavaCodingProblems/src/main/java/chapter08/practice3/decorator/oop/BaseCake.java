package chapter08.practice3.decorator.oop;

public class BaseCake implements Cake{
    @Override
    public String decorate() {
        return "base cake ";
    }
}
