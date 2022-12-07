package chapter08.practice4.factory;

public class Main {

    public static void main(String[] args) {

        Gac gac = (Gac) MelonFactory.newInstance(Gac.class);
        System.out.println(gac);

        Melon hemi = (Melon) MelonFactory.newInstance("Hemi", 3000, "US");
        System.out.println(hemi);
    }

}
