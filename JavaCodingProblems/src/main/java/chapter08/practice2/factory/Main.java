package chapter08.practice2.factory;

public class Main {
    public static void main(String[] args) {
        Fruit gac = MelonFactory.newInstance(Gac.class);
        System.out.println(gac);
        Fruit cantaloupe = MelonFactory.newInstance("Gac", 3000, "USA");
        System.out.println(cantaloupe);
    }
}
