package chapter08.practice1.factory;

public class MelonFruit implements Fruit {

    private String type;
    private int weight;
    private String origin;

    public MelonFruit(String type, int weight, String origin) {
        this.type = type;
        this.weight = weight;
        this.origin = origin;
    }

    public String toString() {
        return type + " " + weight + " " + origin;
    }
}
