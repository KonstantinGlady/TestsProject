package com.gik.testsProject.gik.lambda;

@FunctionalInterface
public interface TernaryIntPredicate {
    boolean test(Integer i1, Integer i2, Integer i3);// write your code here
}
 class Ternary {
    public static final TernaryIntPredicate allValuesAreDifferentPredicate =
            (i1, i2, i3) -> !i1.equals(i2) && !i1.equals(i3) && !i2.equals(i3); // write a lambda expression here
}