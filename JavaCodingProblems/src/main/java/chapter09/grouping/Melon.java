package chapter09.grouping;

import java.util.Objects;

public class Melon {

    enum Sugar {
        LOW, MEDIUM, HIGH, UNKNOWN
    }

    private String type;
    private int weight;
    private Sugar sugar;

    public Melon() {
    }

    public Melon(String type, int weight) {
        this.type = type;
        this.weight = weight;
    }

    public Melon(String type, int weight, Sugar sugar) {
        this.type = type;
        this.weight = weight;
        this.sugar = sugar;
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

    public Sugar getSugar() {
        return sugar;
    }

    public void setSugar(Sugar sugar) {
        this.sugar = sugar;
    }

    public int hashCode() {
        return Objects.hash(type, weight);
    }

    public boolean equals(Object o) {

        if (o == this) return true;
        if (o == null || o.getClass() != getClass()) return false;

        Melon m = (Melon) o;
        return m.weight == weight && Objects.equals(m.type, type) && sugar == m.sugar;
    }

    @Override
    public String toString() {
        return "type='" + type + '\'' +
                ", weight=" + weight +
                ", sugar=" + sugar;
    }
}
