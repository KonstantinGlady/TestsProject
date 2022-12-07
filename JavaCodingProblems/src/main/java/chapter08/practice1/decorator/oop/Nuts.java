package chapter08.practice1.decorator.oop;

public class Nuts extends CakeDecorator {

    public Nuts(Cake cake) {
        super(cake);
    }

    public String decorate() {
        return super.decorate() + decorateWithNuts();
    }

    private String decorateWithNuts() {
        return "with nuts ";
    }
}
