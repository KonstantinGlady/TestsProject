package chapter04;

import java.util.Arrays;
import java.util.Comparator;

public class Max {
    public static void main(String[] args) {

        int[] arr = {1, 3, -4, 6, 2, 8};
        System.out.println(max(arr));
        System.out.println(maxLambda(arr));

        MelonComparable[] melons = {
                new MelonComparable("one", 1),
                new MelonComparable("two", 2),
                new MelonComparable("three", 3)
        };
        System.out.println(maxObject(melons));

        Melon[] melons2 = {
                new Melon("one", 1),
                new Melon("two", 2),
                new Melon("three", 3)
        };
        Comparator<Melon> byType = Comparator.comparing(Melon::getType);
        System.out.println(maxObjectByType(melons2, byType));
        System.out.println(maxObjectByType2(melons2, byType));
    }

    private static <T> T maxObjectByType2(T[] arr, Comparator<? super T> c) {
        T max = arr[0];
        for (T elem :
                arr) {
            if (c.compare(elem, max) > 0) {
                max = elem;
            }
        }
        return max;
    }

    private static <T> T maxObjectByType(T[] arr, Comparator<? super T> byType) {
        return Arrays.stream(arr).max(byType).orElseThrow();
    }

    private static <T extends Comparable<T>> T maxObject(T[] arr) {
        T max = arr[0];
        for (T v : arr) {
            if (v.compareTo(max) > 0) {
                max = v;
            }
        }
        return max;
    }

    private static int maxLambda(int[] arr) {
        return Arrays.stream(arr).max().getAsInt();
    }

    public static int max(int[] arr) {
        int max = arr[0];
        for (int val : arr) {
          /*  if (val > max) {
                max = val;
            }*/
            max = Math.max(val, max);
        }
        return max;
    }
}
