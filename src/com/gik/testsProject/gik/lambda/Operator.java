package com.gik.testsProject.gik.lambda;

import java.util.function.BiFunction;

class Operator {

    // assign a lambda expression to this variable
    static BiFunction<Integer, Integer, Integer> function;

    public static void setFunction(BiFunction<Integer, Integer, Integer> function) {
        Operator.function = (x, y) -> (x < y)? x : y;
    }
}
