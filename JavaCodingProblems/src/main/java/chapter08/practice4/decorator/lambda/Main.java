package chapter08.practice4.decorator.lambda;

public class Main {

    public static void main(String[] args) {

        CakeDecorator decorator = new CakeDecorator(
                (Cake c) -> c.decorate("with cream "),
                (Cake c) -> c.decorate("with nuts ")
        );
        Cake cake = new Cake("base cake ");

        Cake nutsAndCream = decorator.decorate(cake);
        System.out.println(nutsAndCream.getDecorations());

        //

        CakeDecorator nuts = new CakeDecorator(c -> c.decorate("with nuts "));
        CakeDecorator cream = new CakeDecorator(c -> c.decorate("with cream "));
        Cake baseCake = new Cake("base cake ");
        Cake nutsCake = nuts.decorate(baseCake);
        Cake creamNutsCake = cream.decorate(nutsCake);
        System.out.println(baseCake.getDecorations());
        System.out.println(nutsCake.getDecorations());
        System.out.println(creamNutsCake.getDecorations());

    }
}
