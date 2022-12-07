package chapter08.practice4.strategy;

import java.util.function.Function;

public class Main {

    public static void main(String[] args) {

        String str = "asdf 23vawe asdf sadf ";

        String withoutSpace = Remover.remove(str, new WhiteSpaceRemover());
        System.out.println(withoutSpace);

        String withoutNumbers = Remover.remove(withoutSpace, new NumbersRemover());
        System.out.println(withoutNumbers);

        String withoutSpaceL = Remover.remove(str, s -> s.replaceAll("\\s", ""));
        System.out.println(withoutSpaceL);

        String withoutNumbersL = Remover.remove(withoutSpaceL, s -> s.replaceAll("\\d",""));
        System.out.println(withoutNumbersL);
    }
}
