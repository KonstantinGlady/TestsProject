package chapter08.template;

import java.util.function.Consumer;

public class PizzaLambda {

    public void make(Pizza pizza, Consumer<Pizza> consumer) {
        makeDough(pizza);
        consumer.accept(pizza);
        bake(pizza);

    }

    private void makeDough(Pizza pizza) {
        System.out.println("make dough");
    }

    private void bake(Pizza pizza) {
        System.out.println("baking pizza");
    }
}
