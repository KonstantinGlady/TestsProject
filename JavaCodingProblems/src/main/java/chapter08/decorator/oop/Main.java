package chapter08.decorator.oop;

public class Main {
    public static void main(String[] args) {

        Cake cake = new Nuts(new Cream(new BaseCake()));
        System.out.println(cake.decorate());
    }
}
