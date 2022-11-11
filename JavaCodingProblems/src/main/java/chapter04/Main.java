package chapter04;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {

        int[] arr = {1, 3, 6, 23, 32, 3, 6};
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        Integer[] integers = new Integer[]{2, 4, 1, 6, 12};
        Arrays.sort(integers, Collections.reverseOrder());
        System.out.println(Arrays.toString(integers));
        // Arrays.stream(integers).iterator().forEachRemaining(System.out::println);

        Melon[] melons = new Melon[]{
                new Melon("first", 11),
                new Melon("second", 22),
                new Melon("third", 33)
        };
       /* Arrays.sort(melons, new Comparator<Melon>(){
            @Override
            public int compare(Melon o1, Melon o2) {
                return Integer.compare(o1.getWeight(), o2.getWeight());
            }
        });*/
        Arrays.sort(melons, (x, y) -> (-1) * Integer.compare(x.getWeight(), y.getWeight())); // (-1) gives revers sort
        System.out.println(Arrays.toString(melons));

        String[] strings = new String[10];
        Arrays.fill(strings, "");
        strings[0] = "first";
        strings[1] = "second";
        strings[2] = "third";
        strings[3] = "forth";

        System.out.println(Arrays.toString(strings));
        Arrays.sort(strings);
        System.out.println(Arrays.toString(strings));

        int[] arr2 = {3, 6, 1, 54, 32, 11, 21, 65};
        Arrays.sort(arr2);
        System.out.println(Arrays.toString(arr2));

        for (int leftHead = 0, rightHead = arr2.length - 1; leftHead < rightHead; leftHead++, rightHead--) {
            int val = arr2[leftHead];
            arr2[leftHead] = arr2[rightHead];
            arr2[rightHead] = val;
        }
        System.out.println(Arrays.toString(arr2));

        int[] arr3 = {3, 6, 8, 1, 34, 76};
        //bubble sort very slow O(n^2);
        bubbleSort(arr3);
        System.out.println(Arrays.toString(arr3));

        Melon[] melons2 = {
                new Melon("first", 32),
                new Melon("second", 11),
                new Melon("third", 34)};
        Comparator<Melon> byWeight = Comparator.comparing(Melon::getWeight);
        Comparator<Melon> byWeightRevers = Comparator.comparing(Melon::getWeight).reversed();
        bubbleSortWithComparator(melons2, byWeightRevers);
        System.out.println(Arrays.toString(melons2));

        int[] arr4 = {2, 7, 11, 23, 4, 21, 87};
        //insertion sort O(n^2)
        insertionSort(arr4);
        System.out.println(Arrays.toString(arr4));

        Melon[] melons1 = {
                new Melon("first", 22),
                new Melon("second", 32),
                new Melon("third", 54)
        };
        Comparator<Melon> byType = Comparator.comparing(Melon::getType)
                .thenComparing(Melon::getWeight);
        insertionSortWithComparator(melons1, byType);
        System.out.println(Arrays.toString(melons1));

        //counting sort O(n+k)
        int[] arr5 = {3, 2, 5, 12, 8, 2, 6, 3, 11};
        System.out.println(Arrays.toString(arr5));
        countingSort(arr5);
        System.out.println("counting: " + Arrays.toString(arr5));
    }

    private static void countingSort(int[] arr) {
        int min = arr[0];
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            } else if (arr[i] > max) {
                max = arr[i];
            }
        }

        int[] counts = new int[max - min + 1];

        for (int i = 0; i < arr.length; i++) {
            counts[arr[i] - min]++;
        }

        int countedIndex = 0;

        for (int i = 0; i < counts.length; i++) {
            while (counts[i] > 0) {
                arr[countedIndex++] = i + min;
                counts[i]--;
            }
        }
    }

    public static <T> void insertionSortWithComparator(T[] arr, Comparator<? super T> c) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            T key = arr[i];
            int j = i - 1;

            while (j >= 0 && c.compare(arr[j], key) > 0) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    public static <T> void bubbleSortWithComparator(T[] arr, Comparator<? super T> c) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (c.compare(arr[j], arr[j + 1]) > 0) {
                    T tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }
}
