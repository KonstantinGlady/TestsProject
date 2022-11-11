package chapter04;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class FindIndex {

    public static void main(String[] args) {

        int[] arr = {2, 34, 5, 12, 65, 11, 22};
        System.out.println(findIndexOfElement(arr, 2));
        System.out.println(findIndexOfElementLambda(arr, 34));

        Melon[] melons = {
                new Melon("first", 11),
                new Melon("second", 22),
                new Melon("third", 33)
        };
        Comparator<Melon> byWeight = Comparator.comparing(Melon::getWeight);
        System.out.println(findIndexOfElementObject(melons, new Melon("melon", 33), byWeight));
        System.out.println(findIndexOfElementObject(melons, new Melon("first", 11)));
    }

    private static <T> int findIndexOfElementObject(T[] arr, T toFind) {
        return IntStream.range(0, arr.length)
                .filter(i -> arr[i].equals(toFind))
                .findFirst()
                .orElse(-1);
    }

    private static <T> int findIndexOfElementObject(T[] arr, T toFind, Comparator<? super T> c) {
        return IntStream.range(0, arr.length)
                .filter(i -> c.compare(arr[i], toFind) >= 0)
                .findFirst()
                .orElse(-1);
    }


    public static int findIndexOfElementLambda(int[] arr, int toFind) {
        return IntStream.range(0, arr.length)
                .filter(i -> arr[i] == toFind)
                .findFirst()
                .orElse(-1);
    }

    public static int findIndexOfElement(int[] arr, int toFind) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == toFind) {
                return i;
            }
        }
        return -1;
    }
}
