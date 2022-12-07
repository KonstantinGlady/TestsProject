package chapter08.practice2.strategy;

public class Main {
    public static void main(String[] args) {

        String str = " asdfl 23 lasdf ll 534 sdf:";
        String withoutSpace = Remover.remove(str, new WhiteSpaceRemover());
        System.out.println(withoutSpace);
        String withoutNumbers = Remover.remove(str, new NumberRemover());
        System.out.println(withoutNumbers);

        System.out.println(Remover.remove(str, s -> s.replaceAll("\\s", "")));
        System.out.println(Remover.remove(str, s -> s.replaceAll("\\d", "")));
    }
}
