package chapter04;

import java.util.Arrays;

public class Average {

    public static void main(String[] args) {

        int[] arr = {1, 3, 5, 2, 6, 8, 6};
        System.out.println(average(arr));
        System.out.println(averageLambda(arr));
    }

    private static double averageLambda(int[] arr) {
        return Arrays.stream(arr).average().getAsDouble();
    }

    private static double average(int[] arr) {

        return sum(arr) / arr.length;
    }

    private static double sum(int[] arr) {
        double sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return sum;
    }
}

