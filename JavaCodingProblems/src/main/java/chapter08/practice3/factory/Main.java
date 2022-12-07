package chapter08.practice3.factory;

public class Main {
    public static void main(String[] args) {

        Cantaloupe cantaloupe = (Cantaloupe) MelonFactory.newInstance(Cantaloupe.class);
        System.out.println(cantaloupe);

        Melon gac = (Melon) MelonFactory.newInstance("Gac", 3000, "US");
        System.out.println(gac);
    }
}
