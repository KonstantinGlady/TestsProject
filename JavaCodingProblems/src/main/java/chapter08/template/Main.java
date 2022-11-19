package chapter08.template;

public class Main {
    public static void main(String[] args) {
        //base
        Pizza pizza = new Pizza();
        PizzaMaker pmaker = new NeapolitanPizza();
        pmaker.make(pizza);

        //functional
        new PizzaLambda().make(pizza, (Pizza p) -> System.out.println("add: basil leaves, tomatoes, onion"));
    }
}
