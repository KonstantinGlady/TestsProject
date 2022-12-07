package chapter08.practice2.cascade.builder;

public class Main {
    public static void main(String[] args) {

        Delivery.deliver(d -> d.firstname("John")
                .lastname("Smith")
                .address("new york 123")
                .content("parcel"));
    }
}
