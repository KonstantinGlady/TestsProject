package chapter08.practice1.strategy;

public class Main {
    public static void main(String[] args) {
        String s = "asdf asdfllkj 32 ljasdf 23t6";
        //oop
        String strNoNumber = Remover.remove(s, new NumberRemover());
        System.out.println(strNoNumber);
        String strNoSpace = Remover.remove(s, new WhiteSpaceRemover());
        System.out.println(strNoSpace);

        //functional approach
        String strNoNumberL = Remover.remove(s, f -> f.replaceAll("\\d", ""));
        System.out.println(strNoNumberL);
        String strNoSpaceL = Remover.remove(s, f -> f.replaceAll("\\s", ""));
        System.out.println(strNoSpaceL);
    }
}
