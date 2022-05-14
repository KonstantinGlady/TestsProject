package prototype;

import java.util.HashMap;
import java.util.Map;

public class Factory {
    private static Map<String, Person> prototypes = new HashMap<>();

    static {
        prototypes.put("Tom", new Tom());
        prototypes.put("Harry", new Harry());
        prototypes.put("Jack", new Jack());
    }

    public static Person getPrototype(String name) {
        try {
            return prototypes.get(name).clone();
        } catch (NullPointerException e) {
            System.out.println("Person with name: " + name + " doesn't exist!");
            return null;
        }
    }
}
