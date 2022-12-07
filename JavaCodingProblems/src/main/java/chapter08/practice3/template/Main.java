package chapter08.practice3.template;

public class Main {
    public static void main(String[] args) {

        Pizza pizza = new Pizza();
        PizzaMaker pMaker = new GreekPizza();
        pMaker.make(pizza);

        Pizza lPizza = new Pizza();
        PizzaLambda pizzaLambda = new PizzaLambda();
        pizzaLambda.make(lPizza, p -> System.out.println("add to pizza onions, olive, cheese"));
    }
}
