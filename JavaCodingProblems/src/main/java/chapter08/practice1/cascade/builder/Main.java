package chapter08.practice1.cascade.builder;

public class Main {

    public static void main(String[] args) {

        Delivery.deliver(d -> d.firstname("Nick")
                .lastname("Smith")
                .address("nowhere 122")
                .content("very important letter"));

    }
}
