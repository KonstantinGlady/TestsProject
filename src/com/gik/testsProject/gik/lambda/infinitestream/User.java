package com.gik.testsProject.gik.lambda.infinitestream;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

final class Utils {

    private Utils() {
    }

    public static Stream<User> generateUsers(int numberOfUsers) {
      IntStream.rangeClosed(1,5).forEach(System.out::println);
        return Stream.iterate(1, x -> x <= numberOfUsers, x -> x + 1)
                .map(x -> new User(x, String.format("user%d@gmail.com", x)));
    }

    public static void main(String[] args) {
        Stream<User> users = Utils.generateUsers(4);
        users.forEach(System.out::println);
    }
}

class User {
    private final long id;
    private final String email;

    User(long id, String email) {
        this.id = id;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                '}';
    }
}
