package chapter08.strategy.pattern;


import chapter08.Melon;

public interface MelonPredicate {
    boolean test(Melon melon);
}
