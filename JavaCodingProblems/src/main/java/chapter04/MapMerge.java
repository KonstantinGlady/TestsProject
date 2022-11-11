package chapter04;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapMerge {
    public static void main(String[] args) {

        Map<Integer, Melon> map1 = new HashMap<>();
        map1.put(1, new Melon("one", 1));
        map1.put(2, new Melon("two", 2));
        map1.put(3, new Melon("three", 3));

        Map<Integer, Melon> map2 = new HashMap<>();
        map2.put(1, new Melon("one", 1));
        map2.put(2, new Melon("two", 2));
        map2.put(3, new Melon("tree", 3));
        map2.put(4, new Melon("four", 4));

        mergeMap(map1, map2).forEach((k, v) -> System.out.println(k + " " + v));
        mergeMaps(map1, map2).forEach((k, v) -> System.out.println(k + " " + v));
    }

    public static <K, V> Map<K, V> mergeMap(Map<K, V> map1, Map<K, V> map2) {
        Map<K, V> map = new HashMap<>(map1);
        map2.forEach((k, v) -> map.merge(k, v, (v1, v2) -> v2));
        return map;
    }

    public static <K, V> Map<K, V> mergeMaps(Map<K, V> map1, Map<K, V> map2) {
        Stream<Map.Entry<K, V>> merged = Stream.concat(
                map1.entrySet().stream(),
                map2.entrySet().stream()
        );
        Map<K, V> map = merged.collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                (v1, v2) -> v2
        ));
        return map;
    }
}
