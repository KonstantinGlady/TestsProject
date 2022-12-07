package chapter08.practice4.template;

public class Main {

    public static void main(String[] args) {

        Pizza pizza = new Pizza();
        PizzaMaker pizzaMaker = new GreekPizza();
        pizzaMaker.make(pizza);

        //lambda
        Pizza pizzaL = new Pizza();
        PizzaLambda lambda = new PizzaLambda();
        lambda.make(pizzaL, i -> System.out.println("add onions, tomatoes, oives"));
    }
}
