package chapter04;

import java.util.Arrays;
import java.util.Comparator;

public class Equals {
    public static void main(String[] args) {

        int[] arr1 = {1, 2, 3, 4, 7, 9};
        int[] arr2 = {1, 2, 3, 4, 7, 9};
        int[] arr3 = {1, 2, 3, 4, 7, 8};

        System.out.println(Arrays.equals(arr1, arr2));
        System.out.println(Arrays.equals(arr1, 0, 6, arr3, 0, 6));

        Melon[] melons1 = {new Melon("first", 11), new Melon("second", 22)};
        Melon[] melons2 = {new Melon("first", 11), new Melon("second", 22)};
        Melon[] melons3 = {
                new Melon("first", 11),
                new Melon("second", 22),
                new Melon("third", 33)
        };

        Comparator<Melon> byType = Comparator.comparing(Melon::getType);

        System.out.println(Arrays.equals(melons1, 0, 2, melons2, 0, 2, byType));
        System.out.println(Arrays.mismatch(melons1, melons3,  byType));
    }
}
