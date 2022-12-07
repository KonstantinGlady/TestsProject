package chapter08.practice2.template;

public class Main {
    public static void main(String[] args) {

        Pizza gPizza = new Pizza();
        PizzaMaker pMaker = new GreekPizza();
        pMaker.make(gPizza);

        Pizza lPizza = new Pizza();
        new PizzaLambda().make(lPizza, c -> System.out.println("add to pizza tomatos, cheese, mushrooms"));

    }
}
