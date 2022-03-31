package com.gik.testsProject.gik.lambda.parallel.streams;


import java.util.stream.LongStream;

class NumberUtils {
    public static boolean isPrime(long n) {
        return n > 1 && LongStream
                .rangeClosed(2, n - 1)
                .noneMatch(divisor -> n % divisor == 0);
    }
}

public class NumbersUtils {
    public static LongStream createPrimesFilteringStream(long start, long end) {
        // write your code here
        return LongStream.rangeClosed(start, end)
                .parallel()
                .filter(NumberUtils::isPrime);
    }
}