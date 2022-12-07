package chapter08.practice4.functions;

public class GacPredicate implements MelonPredicate {
    @Override
    public boolean test(Melon m) {
        return "gac".equalsIgnoreCase(m.getType());
    }
}
