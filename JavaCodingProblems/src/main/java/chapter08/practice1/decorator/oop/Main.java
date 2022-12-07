package chapter08.practice1.decorator.oop;

public class Main {
    public static void main(String[] args) {

        Cake cake = new Cream(new Nuts(new BaseCake()));
        System.out.println(cake.decorate());

        BaseCake baseCake = new BaseCake();
        Cake nuts = new Nuts(baseCake);
        Cake cream = new Cream(nuts);

        System.out.println(baseCake.decorate());
        System.out.println(nuts.decorate());
        System.out.println(cream.decorate());
    }
}
