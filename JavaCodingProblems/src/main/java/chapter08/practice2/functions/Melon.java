package chapter08.practice2.functions;

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
        return m.weight == weight && Objects.equals(m.type, type) && Objects.equals(m.origin, origin);
    }
}
