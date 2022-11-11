package chapter04;

import java.util.*;

import static java.util.stream.Collectors.toMap;

public class MapSorts {
    public static void main(String[] args) {

        Map<String, MelonComparable> map = new HashMap<>();
        map.put("one", new MelonComparable("one", 1));
        map.put("two", new MelonComparable("two", 2));
        map.put("three", new MelonComparable("three", 3));

        TreeMap<String, MelonComparable> sortedMap = sortByKeyTreeMap(map);

        Map<String, Melon> map1 = new HashMap<>();
        map1.put("one", new Melon("one", 1));
        map1.put("two", new Melon("two", 2));
        map1.put("three", new Melon("three", 3));

        Comparator<String> byKey = Comparator.naturalOrder();
        sortByKeyStream(map1, byKey);
        map1.forEach((k, v) -> System.out.println(k + " " + v));

        Comparator<Melon> byWeight = Comparator.comparing(Melon::getWeight);
        sortByValueStream(map1, byWeight);
        map1.forEach((k, v) -> System.out.println(k + " " + v));

        System.out.println(sortByKeyList(map));
        System.out.println(sortByValueList(map));
    }

    public static <K extends Comparable, V> List<K> sortByKeyList(Map<K, V> map) {
        List<K> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        return list;
    }

    public static <K, V extends Comparable> List<V> sortByValueList(Map<K, V> map) {
        List<V> list = new ArrayList<>(map.values());
        Collections.sort(list);
        return list;
    }

    public static <K, V> Map<K, V> sortByValueStream(Map<K, V> map, Comparator<? super V> c) {
        return map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(c))
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (v1, v2) -> v1, LinkedHashMap::new));
    }

    public static <K, V> Map<K, V> sortByKeyStream(Map<K, V> map, Comparator<? super K> c) {
        return map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey(c))
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (v1, v2) -> v1, LinkedHashMap::new));
    }

    public static <K, V> TreeMap<K, V> sortByKeyTreeMap(Map<K, V> map) {
        return new TreeMap<>(map);
    }
}
