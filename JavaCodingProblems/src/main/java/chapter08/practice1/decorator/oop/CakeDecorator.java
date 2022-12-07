package chapter08.practice1.decorator.oop;

public class CakeDecorator implements Cake {

    private Cake cake;

    public CakeDecorator(Cake cake) {
        this.cake = cake;
    }

    @Override
    public String decorate() {
        return cake.decorate();
    }
}
