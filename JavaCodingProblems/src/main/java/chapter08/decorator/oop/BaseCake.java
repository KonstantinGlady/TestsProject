package chapter08.decorator.oop;

public class BaseCake implements Cake {
    @Override
    public String decorate() {
        return "Base cake ";
    }
}
