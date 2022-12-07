package chapter08.practice1.factory;

public class Main {

    public static void main(String[] args) {
        Gac gac = (Gac) MelonFactory.newInstance(Gac.class);
        System.out.println(gac);
        MelonFruit melon = (MelonFruit) MelonFactory.newInstance("Gac", 3000, "USA");
        System.out.println(melon);
    }
}
