package com.gik.testsProject.gik.lambda;

import java.util.Scanner;
import java.util.function.Function;

class DigitsSubstitution {

    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);

        long n = 4L;//scanner.nextInt();

        int result = Utils.substitution(n, digit -> {
            if (digit == 5) {
                digit = 1;
            } else if (digit == 6) {
                digit = 2;
            } else if (digit == 7) {
                digit = 3;
            } else if (digit == 8) {
                digit = 4;
            } else if (digit == 9) {
                digit = 5;
            }
            return digit;
        }); // modify the lambda expression

        System.out.println(result);
    }
}

class Utils {

    public static int substitution(long n, Function<Integer, Integer> digitRule) {
        String numberAsString = String.valueOf(n);
        int result = 0;

        for (int i = 0; i < numberAsString.length(); i++) {
            result *= 10;
            int nextDigit = Integer.parseInt(String.valueOf(numberAsString.charAt(i)));
            result += digitRule.apply(nextDigit);
        }

        return result;
    }
}
