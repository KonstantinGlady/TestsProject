package chapter08.factory.pattern;

public class Melon implements Fruit {

    private String name;
    private int weight;
    private String color;

    public Melon(String name, int weight, String color) {
        this.name = name;
        this.weight = weight;
        this.color = color;
    }

    public String toString() {
        return name + " " + weight + " " + color;
    }
}
