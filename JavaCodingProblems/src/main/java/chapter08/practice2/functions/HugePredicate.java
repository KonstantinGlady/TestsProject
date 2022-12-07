package chapter08.practice2.functions;

public class HugePredicate implements MelonPredicate{
    @Override
    public boolean test(Melon m) {
        return m.getWeight() > 4000;
    }
}
