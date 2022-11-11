package chapter04;

import java.util.Objects;

public class ImmutableMelon {

    private final String type;
    private final int weight;

    public ImmutableMelon(String type, int weight) {
        this.type = type;
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public int getWeight() {
        return weight;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (o == null || o.getClass() != getClass()) return false;
        ImmutableMelon m = (ImmutableMelon) o;
        return m.weight == weight && Objects.equals(m.type, type);
    }

    public int hashCode() {
        return Objects.hash(weight, type);
    }

    public String toString() {
        return "weight: " + weight + " type: " + type;
    }
}
