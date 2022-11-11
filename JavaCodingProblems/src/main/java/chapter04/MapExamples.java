package chapter04;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class MapExamples {
    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        System.out.println(map.get("key3"));//gives null
        System.out.println(map.getOrDefault("key3", "value3"));//gives default value

        BiFunction<String, String, String> makeString = (k, v) -> "key: " + k + " value: " + v;
        System.out.println(map.computeIfPresent("key1", makeString));//if not null

        map.put("key3", null);
        map.put(null, "value4");
        Function<String, String> defaultValue = x -> "default";

        System.out.println("set:");
        for (Map.Entry<String, String> e : map.entrySet()) {
            System.out.println(e.getKey() + " " + e.getValue());
        }

        System.out.println("key3 " + map.get("key3"));
        map.computeIfAbsent("key3", defaultValue);
        System.out.println("key3 " + map.get("key3"));

        System.out.println("key4" + map.get("key4"));
        map.computeIfAbsent("key4", defaultValue);
        System.out.println("key4" + map.get("key4"));

        System.out.println("set:");
        map.forEach((x, y) -> System.out.println(x + " " + y));

        BiFunction<String, String, String> concat = String::concat;
        //BiFunction<String, String, String> concat = (x, y) -> x.concat(y);

        map.merge("key2", " full", concat);
        System.out.println("key2: " + map.get("key2"));

        System.out.println(map.putIfAbsent("key3", "value03"));
        System.out.println(map.putIfAbsent("key33", "value33"));

        System.out.println("revomed item: " + map.remove("key3"));
        System.out.println("removed item: " + map.remove("key4", "default"));

        map.entrySet().removeIf(x -> x.getValue().equals("default"));
        System.out.println("set");
        map.forEach((k, v) -> System.out.println("key " + k + " value " + v));

        Map<Integer, Melon> melons = new HashMap<>();
        melons.put(1, new Melon("one", 1000));
        melons.put(2, new Melon("two", 2000));
        melons.put(3, new Melon("three", 3000));

        melons.replace(1, new Melon("four", 4000));
        System.out.println(melons.get(1));
        melons.replace(1, new Melon("four", 4000), new Melon("five", 5000));
        System.out.println(melons.get(1));
        BiFunction<Integer, Melon, Melon> biggerThen1000 = (k, v) -> {
            if (v.getWeight() > 1000) {
                return new Melon(v.getType(), 1000);
            }
            return v;
        };
        BiFunction<Integer, Melon, Melon> biggerThen2000 = (k, v) ->
                (v.getWeight() > 2000) ? new Melon(v.getType(), 1000) : v;


        melons.replaceAll(biggerThen2000);
        melons.forEach((k, v) -> System.out.println(k + " " + " " + v));

        Map<Integer, Melon> map1 = new HashMap<>();
        map1.put(1, new Melon("one", 1));
        map1.put(2, new Melon("two", 2));
        map1.put(3, new Melon("three", 3));

        Map<Integer, Melon> map2 = new HashMap<>();
        map2.put(1, new Melon("one", 1));
        map2.put(2, new Melon("two", 2));
        map2.put(3, new Melon("three", 3));

        System.out.println("maps are equals: " + map1.equals(map2));//true

        Melon[] arr1 = {
                new Melon("one", 1),
                new Melon("two", 2),
                new Melon("three", 3)};
        Melon[] arr2 = {
                new Melon("one", 1),
                new Melon("two", 2),
                new Melon("three", 3)
        };
        Map<Integer, Melon[]> map3 = new HashMap<>();
        map3.put(1, arr1);
        Map<Integer, Melon[]> map4 = new HashMap<>();
        map4.put(1, arr2);
        System.out.println(map3.equals(map4));//false
        System.out.println(equalsWithArrays(map3, map4));//true


    }

    public static <A, B> boolean equalsWithArrays(Map<A, B[]> map1, Map<A, B[]> map2) {
        return map1.entrySet().stream()
                .allMatch(e -> Arrays.equals(e.getValue(), map2.get(e.getKey())));
    }
}
