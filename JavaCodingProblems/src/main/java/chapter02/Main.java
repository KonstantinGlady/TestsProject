package chapter02;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(23, 5, 1, 6, null, 7, null, 9, 8);

        System.out.println(sumIntegers(list));
        System.out.println(listContainsNulls(list));
    }



    private static boolean listContainsNulls(List<Integer> list) {
        if (Objects.isNull(list)) {
            return false;
        }
        return list.stream()
                .anyMatch(Objects::isNull);
    }

    private static int sumIntegers(List<Integer> list) {
        if (Objects.isNull(list)) {
            throw new IllegalArgumentException("List cannot be null");
        }
        return list.stream()
                .filter(Objects::nonNull)
                .mapToInt(Integer::intValue)
                .sum();
    }
}

