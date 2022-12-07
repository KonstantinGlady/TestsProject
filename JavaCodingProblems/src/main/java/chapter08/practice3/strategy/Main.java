package chapter08.practice3.strategy;

public class Main {
    public static void main(String[] args) {

        String withNoSpace = Remover.remove("asdf asdf asdf", new WhiteSpaceRemove());
        System.out.println(withNoSpace);

        String s = Remover.remove("asdf 23 asdf 23r", s1 -> s1.replaceAll("\\d", ""));
        System.out.println(s);
    }
}
