package chapter08.practice3.decorator.oop;

public class Nuts extends CakeDecorator{

    public Nuts(Cake cake) {
        super(cake);
    }

    @Override
    public String decorate() {
        return super.decorate() + decorateWithNuts();
    }

    public String decorateWithNuts() {
        return "with nuts ";
    }
}
