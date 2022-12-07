package chapter08.practice1.template;

public class Main {
    public static void main(String[] args) {

        Pizza pizza = new Pizza();
        GreekPizza gPizza = new GreekPizza();
        gPizza.make(pizza);
        System.out.println();

        Pizza pizzaL = new Pizza();
        new PizzaLambda().make(pizzaL, (Pizza p) -> System.out.println("add ingredients onion, cheese, tomatoes"));
    }
}
