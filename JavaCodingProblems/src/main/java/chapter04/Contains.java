package chapter04;

import java.util.Arrays;
import java.util.Comparator;

public class Contains {

    public static void main(String[] args) {

        int[] arr = {2, 3, 5, 1, 34, 12, 53, 87};
        int n = 3;
        System.out.println(containsElement(arr, n));
        System.out.println(containsElementBinarySearch(Arrays.copyOf(arr, arr.length), n));
        System.out.println(containsElementLambda(arr, n));

        Melon[] melons = {
                new Melon("first", 22),
                new Melon("second", 32),
                new Melon("third", 44)
        };
        System.out.println(containsElementObject(melons, new Melon("first", 22)));

        Comparator<Melon> byWeight = Comparator.comparing(Melon::getWeight);

        System.out.println(containsElementObject(melons, new Melon("first", 22), byWeight));

        System.out.println(
                containsElementObjectBinarySearch(
                        Arrays.copyOf(melons, melons.length),
                        new Melon("first", 22),
                        byWeight
                )
        );
    }

    private static <T> boolean containsElementObjectBinarySearch(T[] arr, T obj, Comparator<? super T> c) {
        Arrays.sort(arr, c);
        int index = Arrays.binarySearch(arr, obj, c);
        return (index >= 0);
    }

    private static <T> boolean containsElementObject(T[] arr, T t) {
        for (T a : arr) {
            if (a.equals(t)) {
                return true;
            }
        }
        return false;
    }

    private static <T> boolean containsElementObject(T[] arr, T object, Comparator<? super T> c) {
        for (T element : arr) {
            if (c.compare(element, object) >= 0) {
                return true;
            }
        }
        return false;
    }

    private static boolean containsElementLambda(int[] arr, int n) {
        return Arrays.stream(arr).anyMatch(i -> i == n);
    }

    private static boolean containsElementBinarySearch(int[] arr, int n) {
        Arrays.sort(arr);
        int index = Arrays.binarySearch(arr, n);
        return (index >= 0);
    }

    private static boolean containsElement(int[] arr, int n) {
        for (int a : arr) {
            if (a == n) {
                return true;
            }
        }
        return false;
    }

}
