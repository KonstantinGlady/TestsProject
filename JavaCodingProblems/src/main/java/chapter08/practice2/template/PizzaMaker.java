package chapter08.practice2.template;

public abstract class PizzaMaker {

    public void make(Pizza pizza) {
        makeDough(pizza);
        addIngredients(pizza);
        bake(pizza);
    }

    private void makeDough(Pizza pizza) {
        System.out.println("make dough");
    }

    private void bake(Pizza pizza) {
        System.out.println("bake pizza");
    }

    public abstract void addIngredients(Pizza pizza);
}
