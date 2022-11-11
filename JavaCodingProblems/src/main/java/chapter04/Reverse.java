package chapter04;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

public class Reverse {
    public static void main(String[] args) {

        int[] arr = {2, 3, 5, 6, 8, 1};
        System.out.println(Arrays.toString(reverse(arr)));
        System.out.println(Arrays.toString(reverseLambda(arr)));

        Melon[] melons = {
                new Melon("one", 1),
                new Melon("two", 2),
                new Melon("three", 3)
        };
        Collections.reverse(Arrays.asList(melons));
        System.out.println(Arrays.toString(melons));
        System.out.println(Arrays.toString(reverseObjects(melons)));
    }

    private static Melon[] reverseObjects(Melon[] arr) {
        return IntStream.rangeClosed(1, arr.length)
                .mapToObj(i -> arr[arr.length - i])
                .toArray(Melon[]::new);
    }

    private static int[] reverseLambda(int[] ints) {
        return IntStream.rangeClosed(1, ints.length)
                .map(i -> ints[ints.length - i]).toArray();
    }

    public static int[] reverse(int[] ints) {
        int[] arr = Arrays.copyOf(ints, ints.length);
        for (int left = 0, right = arr.length - 1; left < right; left++, right--) {
            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
        }
        return arr;
    }
}
