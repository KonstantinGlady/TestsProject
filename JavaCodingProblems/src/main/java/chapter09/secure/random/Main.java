package chapter09.secure.random;

import java.security.SecureRandom;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        Supplier<String> passwordSupplier = Main::randomPassword;
        Stream<String> passwordStream = Stream.generate(passwordSupplier);
        List<String> result = passwordStream
                .limit(10)
                .collect(Collectors.toList());
        result.forEach(System.out::println);
    }

    private static String randomPassword() {

        String chars = "ASDFZXCV$%^EE13234";

        return new SecureRandom().ints(8, 0, chars.length())
                .mapToObj(n -> String.valueOf(chars.charAt(n)))
                .collect(Collectors.joining());
    }
}
