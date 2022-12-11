package chapter08.practice4.factory;

public class Melon implements Fruit {

    private String type;
    private int weight;
    private String origin;

    public Melon() {}
    public Melon(String type, int weight, String origin) {
        this.type = type;
        this.weight = weight;
        this.origin = origin;
    }

    public String toString() {
        return type + " " + weight + " " + origin;
    }
}
