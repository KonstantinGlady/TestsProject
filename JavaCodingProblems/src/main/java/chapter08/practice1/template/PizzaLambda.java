package chapter08.practice1.template;

import java.util.function.Consumer;

public class PizzaLambda {

    public void make(Pizza pizza, Consumer<Pizza> addIngredients) {
        makeDough(pizza);
        addIngredients.accept(pizza);
        bake(pizza);
    }

    private void makeDough(Pizza pizza) {
        System.out.println("making dough");
    }

    private void bake(Pizza pizza) {
        System.out.println("bake pizza");
    }
}
