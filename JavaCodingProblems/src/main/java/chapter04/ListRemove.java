package chapter04;

import java.util.*;
import java.util.stream.Collectors;

public class ListRemove {
    public static void main(String[] args) {

        List<Melon> list = new ArrayList<>();
        list.add(new Melon("one", 1));
        list.add(new Melon("two", 2));
        list.add(new Melon("three", 3));

        list.removeIf(a -> a.getWeight() > 2);
        System.out.println(list);

        list.add(new Melon("three", 3));
        List<Melon> weightLessThen2 = list.stream()
                .filter(a -> a.getWeight() < 2)
                .collect(Collectors.toList());
        System.out.println("list less 2 " + weightLessThen2);

        Map<Boolean, List<Melon>> map = list.stream()
                .collect(Collectors.partitioningBy(a -> a.getWeight() > 2));
        List<Melon> weightLessThen22 = map.get(false);
        List<Melon> weightGreaterThen22 = map.get(true);
        System.out.println(weightLessThen22);
        System.out.println(weightGreaterThen22);

        boolean allTheSame = Collections.frequency(list, list.get(0)) == list.size();
        System.out.println(allTheSame);

        List<String> strings = Arrays.asList("one", "two", "three");
        Object[] objects = strings.toArray();
        String[] str = strings.toArray(String[]::new);
        System.out.println(Arrays.toString(str));
        System.out.println(Arrays.toString(objects));
    }
}
