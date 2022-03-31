package com.gik.testsProject.gik.lambda.parallel.streams;

import java.util.List;

public class Examples {
    public static void main(String[] args) {

        System.out.println(List.of(1, 2, 3, 4).parallelStream().reduce(1, (partialResult, n) -> partialResult * n));
        System.out.println(List.of(1, 2, 3).parallelStream().reduce(1, (partialResult, n) -> partialResult * n) * 4);
        System.out.println(List.of(1, 2, 3).stream().reduce(4, (partialResult, n) -> partialResult * n));
        System.out.println(List.of(1, 2, 3).parallelStream().reduce(4, (partialResult, n) -> partialResult * n));//problem with starting value not 1 or 0 when parallelstrem used 384 except 24
    }
}
