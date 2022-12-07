package chapter08.practice1.decorator.oop;

public class BaseCake implements Cake{
    @Override
    public String decorate() {
        return "Base cake ";
    }
}
