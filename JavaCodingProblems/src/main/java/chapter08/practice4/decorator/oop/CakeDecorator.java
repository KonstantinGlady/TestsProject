package chapter08.practice4.decorator.oop;

public class CakeDecorator implements Cake {

    private final Cake cake;

    public CakeDecorator(Cake cake) {
        this.cake = cake;
    }

    @Override
    public String decorate() {
        return cake.decorate();
    }
}
