package chapter04;

import java.util.Arrays;

public class Filling {
    public static void main(String[] args) {

        int[] arr = new int[10];
        Arrays.fill(arr, 1);
        System.out.println(Arrays.toString(arr));

        Arrays.setAll(arr, i -> {
            if (i == 0) {
                return arr[i];
            } else {
                return arr[i - 1] + 1;
            }
        });
        System.out.println(Arrays.toString(arr));

        //When we use parallelSetAll be careful with logic of the generator. it shouldn't use previous element in chain
        Arrays.parallelSetAll(arr, i -> {
            if (i % 2 == 0) {
                return arr[i] * arr[i];
            } else {
                return arr[i - 1] + 1;
            }
        });
        System.out.println(Arrays.toString(arr));

        Arrays.parallelPrefix(arr, (x, y) -> x + y);//Integer::sum
        System.out.println(Arrays.toString(arr));
    }
}
