package chapter08.practice2.decorator.oop;

public class Cream extends CakeDecorator {

    public Cream(Cake cake) {
        super(cake);
    }

    public String decorate() {
        return super.decorate() + decorateWithCream();
    }

    public String decorateWithCream() {
        return "with cream ";
    }
}
