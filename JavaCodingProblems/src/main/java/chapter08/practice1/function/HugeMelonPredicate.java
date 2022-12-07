package chapter08.practice1.function;

public class HugeMelonPredicate implements MelonPredicate {
    @Override
    public boolean test(Melon m) {
        return m.getWeight() > 5000;
    }
}
