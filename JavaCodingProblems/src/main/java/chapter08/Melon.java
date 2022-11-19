package chapter08;

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

    public boolean equals(Object o) {
        if (o == this) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        Melon m = (Melon) o;
        return m.weight == this.weight &&
                Objects.equals(m.type, this.type) &&
                Objects.equals(m.origin, this.origin);
    }

    public int hashCode() {
        return Objects.hash(weight, origin, type);
    }

    public String toString() {
        return "type: " + type + " weight: " + weight + " origin: " + origin;
    }
}
