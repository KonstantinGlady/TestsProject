package chapter08.practice4.decorator.oop;

public class Main {

    public static void main(String[] args) {

        Cake cake = new Nuts(new Cream(new BaseCake()));
        System.out.println(cake.decorate());

        Cake baseCake = new BaseCake();
        Cake nuts = new Nuts(baseCake);
        Cake cream = new Cream(nuts);
        System.out.println(baseCake.decorate());
        System.out.println(nuts.decorate());
        System.out.println(cream.decorate());
    }
}
