package chapter08.practice3.functional;

public class BaelonePredicate implements MelonPredicate {
    @Override
    public boolean test(Melon m) {
        return "baelone".equalsIgnoreCase(m.getType());
    }
}
