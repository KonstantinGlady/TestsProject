package prototype;

import java.util.List;

public class Demo {
    private static  List<String> names = List.of("Tom", "Jack", "Harry", "Jim");

    public static void main(String[] args) {
        for (String n : names) {
           Person person = Factory.getPrototype(n);
            if (person != null) {
                System.out.println(n);
            }
        }
    }
}
