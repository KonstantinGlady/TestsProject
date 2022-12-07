package chapter08.practice1.decorator.lambda;

public class Main {
    public static void main(String[] args) {

        CakeDecorator cakeDecorator = new CakeDecorator(
                (Cake c) -> c.decorate("with cream "),
                (Cake c) -> c.decorate("with nuts ")
        );
        Cake cake = cakeDecorator.decorate(new Cake("Base cake "));
        System.out.println(cake.getDecorations());

        ///
        CakeDecorator cream = new CakeDecorator(c -> c.decorate("with cream "));
        CakeDecorator nuts = new CakeDecorator(c -> c.decorate("with nuts "));

        Cake baseCake = new Cake("Base cake ");
        System.out.println(baseCake.getDecorations());

        Cake withNuts = nuts.decorate(baseCake);
        System.out.println(withNuts.getDecorations());

        Cake withCream = cream.decorate(withNuts);
        System.out.println(withCream.getDecorations());
    }
}
