package chapter02.builder;

import static chapter02.builder.User.getBuilder;

public class Main {
    public static void main(String[] args) {

        var user = getBuilder("Mick", "pass")
                .firstname("Mick")
                .lastname("Johnson")
                .email("qwer@asdf.ru")
                .build();

        System.out.println(user + " " + user.getCreated());
    }
}
