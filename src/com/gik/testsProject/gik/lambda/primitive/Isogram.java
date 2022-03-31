package com.gik.testsProject.gik.lambda.primitive;

import java.util.Scanner;

class Isogram {

    public static boolean isIsogram(String word) {

            return word.chars().distinct().count() == word.length();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word = "stream";// scanner.nextLine();

        System.out.println(isIsogram(word));
    }
}
