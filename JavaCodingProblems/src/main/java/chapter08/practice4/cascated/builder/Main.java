package chapter08.practice4.cascated.builder;

public class Main {

    public static void main(String[] args) {

        Delivery.deliver(p -> p.firstname("John")
                .lastname("Smith")
                .address("New York")
                .content("parcel"));
    }
}
