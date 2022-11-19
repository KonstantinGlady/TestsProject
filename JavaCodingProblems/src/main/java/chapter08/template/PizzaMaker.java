package chapter08.template;

public abstract class PizzaMaker {

    public void make(Pizza pizza) {
        makeDough(pizza);
        addTopIngredients(pizza);
        bake(pizza);
    }

    private void makeDough(Pizza pizza) {
        System.out.println("making dough");
    }

    private void bake(Pizza pizza) {
        System.out.println("baking pizza");
    }

    public abstract void addTopIngredients(Pizza pizza);
}
