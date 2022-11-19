package chapter08.template;

public class NeapolitanPizza extends PizzaMaker {
    @Override
    public void addTopIngredients(Pizza pizza) {
        System.out.println("add : fresh mozzarella, tomatoes, basil leaves  ");
    }
}
