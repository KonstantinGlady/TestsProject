package chapter08.practice2.decorator.lambda;

public class Main {

    @SuppressWarnings("unchecked ")
    public static void main(String[] args) {

        CakeDecorator nutsAndCream = new CakeDecorator(
                (Cake c) -> c.decorate("with nuts "),
                (Cake c) -> c.decorate("with cream ")
        );
        Cake cake = nutsAndCream.decorate(new Cake("base cake "));
        System.out.println(cake.getDecorations());

        CakeDecorator nuts = new CakeDecorator(c -> c.decorate("with nuts "));
        CakeDecorator cream = new CakeDecorator(c -> c.decorate("with cream "));
        Cake base = new Cake("base cake ");
        Cake withNuts = nuts.decorate(base);
        Cake withCream = cream.decorate(withNuts);
        System.out.println(base.getDecorations());
        System.out.println(withNuts.getDecorations());
        System.out.println(withCream.getDecorations());
    }
}
