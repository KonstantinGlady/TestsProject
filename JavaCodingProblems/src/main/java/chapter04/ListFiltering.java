package chapter04;

import java.util.*;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class ListFiltering {
    public static void main(String[] args) {

        List<Melon> melons = new ArrayList<>();
        melons.add(new Melon("one", 1));
        melons.add(new Melon("two", 2));
        melons.add(new Melon("three", 3));
        melons.add(new Melon("four", 4));

        //List works through "for" slow version
        List<String> melonsByType = Arrays.asList("one", "two", "three");

        List<Melon> result = melons.stream()
                .filter(a -> melonsByType.contains(a.getType()))
                .collect(Collectors.toList());
        System.out.println(result);

        //HashSet works through HashSet.contains() which is actually is Map.containsKey(). much faster
        Set<String> melonsSetByType = new HashSet<>(melonsByType);
       /* Set<String> melonsSetByType = melonsByType.stream()
                .collect(Collectors.toSet());*/


        List<Melon> result2 = melons.stream()
                .filter(a -> melonsSetByType.contains(a.getType()))
                .collect(Collectors.toList());
        System.out.println(result2);


        UnaryOperator<Melon> operator = a -> (a.getWeight() > 2) ? new Melon(a.getType(), 2) : a;
        melons.replaceAll(operator);
        System.out.println(melons);
    }
}
