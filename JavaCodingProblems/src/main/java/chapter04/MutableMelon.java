package chapter04;

import java.util.Objects;

public class MutableMelon {

    private String type;
    private int weight;

    public MutableMelon(String type, int weight) {
        this.type = type;
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public int getWeight() {
        return weight;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setWeight(int weight) {
        this.weight = weight;
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
        MutableMelon melon = (MutableMelon) o;
        return weight == melon.weight && Objects.equals(type, melon.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, weight);
    }
}
