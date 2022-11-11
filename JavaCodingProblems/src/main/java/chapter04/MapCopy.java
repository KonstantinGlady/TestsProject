package chapter04;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class MapCopy {
    public static void main(String[] args) {

        Map<String, Melon> map = new HashMap<>();

        Map<String, Melon> mapCopy = new HashMap<>(map);

        Map<String, Melon> mapCopy2 = new HashMap<>();
        mapCopy2.putAll(map);

        HashMap<String, Melon> mapCopy3 = shallowCopy(map);
    }

    @SuppressWarnings("unchecked")
    public static <K, V> HashMap<K, V> shallowCopy(Map<K, V> map) {
        Set<Map.Entry<K, V>> set = map.entrySet();
        HashMap<K, V> copyMap = (HashMap<K, V>) set.stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue
                ));
        return copyMap;
    }
}
