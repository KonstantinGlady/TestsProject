package chapter08.builder;

public class Main {

    public static void main(String[] args) {

        Delivery.deliver(d -> d.firstname("Alex")
                .lastname("Smith")
                .address("nowhere str. 123")
                .content("letter"));
    }
}
