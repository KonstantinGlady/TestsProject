package chapter08.practice2.functions;

public class GacPredicate implements MelonPredicate {
    @Override
    public boolean test(Melon m) {
        return "gac".equalsIgnoreCase(m.getType());
    }
}
