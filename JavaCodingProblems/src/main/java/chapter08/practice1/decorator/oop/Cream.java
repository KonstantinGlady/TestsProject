package chapter08.practice1.decorator.oop;

public class Cream extends CakeDecorator {

    public Cream(Cake cake) {
        super(cake);
    }

    public String decorate() {
        return super.decorate() + decorateWithCream();
    }

    private String decorateWithCream() {
        return "with cream ";
    }
}
