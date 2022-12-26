package chapter09;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Melon {

    private String type;
    private int weight;

    private List<String> pests;

    public Melon() {
    }

    public Melon(String type, int weight) {
        this.type = type;
        this.weight = weight;
        this.pests = new ArrayList<>();
    }

    public Melon(String type, int weight, List<String> pests) {
        this.type = type;
        this.weight = weight;
        this.pests = pests;
    }

    public List<String> getPests() {
        return pests;
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

    public String toString() {
        return type + " " + weight;
    }

    public int hashCode() {
        return Objects.hash(type, weight);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != getClass()) return false;

        Melon m = (Melon) o;
        return Objects.equals(type, m.type) && weight == m.weight;
    }


}
