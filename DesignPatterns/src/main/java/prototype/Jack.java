package prototype;

public class Jack implements Person {
    private final String NAME = "Jack";

    @Override
    public Person clone() {
        return new Jack();
    }

    @Override
    public String toString() {
        return NAME;
    }
}
