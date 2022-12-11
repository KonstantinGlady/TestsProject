package chapter08.practice1.function;

import java.util.Objects;

public class Melon {

    private String type;
    private int weight;
    private String origin;

    public Melon() {}
    public Melon(String type, int weight, String origin) {
        this.type = type;
        this.weight = weight;
        this.origin = origin;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String toString() {
        return type + " " + weight + " " + origin;
    }

    public int hashCode() {
        return Objects.hash(type, weight, origin);
    }

    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        if (o == this) return true;

        Melon m = (Melon) o;

        return Objects.equals(m.type, type) && m.weight == weight && Objects.equals(m.origin, origin);
    }
}
