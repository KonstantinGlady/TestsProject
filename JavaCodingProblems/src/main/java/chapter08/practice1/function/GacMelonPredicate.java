package chapter08.practice1.function;

public class GacMelonPredicate implements MelonPredicate {
    @Override
    public boolean test(Melon m) {
        return "gac".equalsIgnoreCase(m.getType());
    }
}
