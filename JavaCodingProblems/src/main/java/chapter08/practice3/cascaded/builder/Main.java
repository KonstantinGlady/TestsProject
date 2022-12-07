package chapter08.practice3.cascaded.builder;

public class Main {
    public static void main(String[] args) {

        Delivery.deliver(d -> d.firstname("John")
                .lastname("Smith")
                .address("nowhere 123")
                .content("parcel"));
    }
}
