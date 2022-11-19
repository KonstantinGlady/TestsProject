package chapter08.strategy.pattern;

import chapter08.Melon;

public class OnePredicate implements MelonPredicate {
    @Override
    public boolean test(Melon melon) {
        return melon.getType().equalsIgnoreCase("one");
    }
}
