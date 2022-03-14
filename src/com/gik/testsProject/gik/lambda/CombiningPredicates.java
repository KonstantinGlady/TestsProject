package com.gik.testsProject.gik.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class CombiningPredicates {

    /**
     * The method represents the conjunction operator for a list of predicates.
     * For an empty list it returns the always true predicate.
     */
    public static IntPredicate conjunctAll(List<IntPredicate> predicates) {
       // return n -> true; // write your code here
        IntPredicate p = (x) -> true;
        for (IntPredicate i : predicates) {
            p = p.and(i);
        }
        return p;
    }

    public static <T> Predicate<T> xor(Predicate<T> predicate1, Predicate<T> predicate2) {
        return  (predicate1.or(predicate2)).and(predicate1.and(predicate2).negate()); // write your code here
    }

    // Don't change the code below
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] strings = scanner.nextLine().split("\\s+");

        List<Boolean> values;
        if (strings[0].trim().length() == 0) {
            values = List.of();
        } else {
            values = Arrays.stream(strings)
                    .map(Boolean::parseBoolean)
                    .collect(Collectors.toList());
        }

        List<IntPredicate> predicates = new ArrayList<>();
        values.forEach(v -> predicates.add(x -> v));

        System.out.println(conjunctAll(predicates).test(0));
    }
}
