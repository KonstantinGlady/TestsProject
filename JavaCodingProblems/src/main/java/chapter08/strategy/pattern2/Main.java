package chapter08.strategy.pattern2;

public class Main {

    public static void main(String[] args) {

        //base
        String origin = "My tested 23 string 65";
        String result = Remover.remove(origin, new NumberRemover());
        System.out.println(result);
        String result2 = Remover.remove(result, new WhiteSpaceRemover());
        System.out.println(result2);

        //functional
        String result3 = Remover.remove(origin, s -> s.replaceAll("\\d", ""));
        System.out.println(result3);
        String result4 = Remover.remove(result3, s -> s.replaceAll("\\s", ""));
        System.out.println(result4);
    }
}
