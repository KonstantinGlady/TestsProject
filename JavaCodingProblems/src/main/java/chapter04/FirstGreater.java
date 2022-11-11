package chapter04;

public class FirstGreater {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 12, 2, 1, 4};
        firstGreater(arr);
    }

    private static void firstGreater(int[] arr) {
        int nge;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            nge = -1;
            for (int j = i + 1; j < n; j++) {
                if (arr[i] < arr[j]) {
                    nge = arr[j];
                    break;
                }
            }
            System.out.print(arr[i] + ":" + nge + " ");
        }
    }
}
