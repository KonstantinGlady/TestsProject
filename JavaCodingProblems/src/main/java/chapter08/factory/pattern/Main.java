package chapter08.factory.pattern;

public class Main {

    public static void main(String[] args) {
        Gag gag = (Gag) MelonFactory.newInstance(Gag.class);
        Melon melon = (Melon) MelonFactory.newInstance("Melon",2000,"white");
    }
}
