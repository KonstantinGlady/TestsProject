package chapter08.practice3.decorator.oop;

public class Main {
    public static void main(String[] args) {

        Cake cake = new Nuts(new Cream(new BaseCake()));
        System.out.println(cake.decorate());

        Cake base = new BaseCake();
        Cake nuts = new Nuts(base);
        Cake cream = new Cream(nuts);
        System.out.println(base.decorate());
        System.out.println(nuts.decorate());
        System.out.println(cream.decorate());
    }
}
