package chapter08.decorator.lambda;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        CakeDecorator nutsAndCream = new CakeDecorator(
                (Cake c) -> c.decorate("with nuts "),
                (Cake c) -> c.decorate("with cream "));
        Cake cake = nutsAndCream.decorate(new Cake("Base cake "));
        System.out.println(cake.getDecorations());

        ////
        CakeDecorator nuts = new CakeDecorator(c -> c.decorate("with nuts "));
        CakeDecorator cream = new CakeDecorator(c -> c.decorate("with cream "));
        Cake baseCake = new Cake("Base cake ");
        Cake withNuts = nuts.decorate(baseCake);
        Cake withCream = cream.decorate(withNuts);
        System.out.println(baseCake.getDecorations());
        System.out.println(withNuts.getDecorations());
        System.out.println(withCream.getDecorations());

    }
}
