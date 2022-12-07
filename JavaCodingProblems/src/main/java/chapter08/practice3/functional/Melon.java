package chapter08.practice3.functional;

import java.util.Objects;

public class Melon {

    private String type;
    private int weight;
    private String origin;

    public Melon(String type, int weight, String origin) {
        this.type = type;
        this.weight = weight;
        this.origin = origin;
    }

    public String getType() {
        return type;
    }

    public int getWeight() {
        return weight;
    }

    public String getOrigin() {
        return origin;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setWeight(int weight) {
        this.weight = weight;
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
        if (o == this) return true;
        if (o == null || o.getClass() != getClass()) return false;

        Melon m = (Melon) o;
        return Objects.equals(type, m.type) && weight == m.weight && Objects.equals(origin, m.origin);
    }
}
