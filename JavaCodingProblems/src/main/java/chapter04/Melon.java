package chapter04;

import java.util.Objects;

public class Melon {

    private final String type;
    private final int weight;

    public Melon(String type, int weight) {
        this.type = type;
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public int getWeight() {
        return weight;
    }


    @Override
    public String toString() {
        return "Melon{" +
                "type='" + type + '\'' +
                ", weight=" + weight +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Melon melon = (Melon) o;
        return weight == melon.weight && Objects.equals(type, melon.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, weight);
    }
}
