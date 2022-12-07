package chapter08.practice2.functions;

@FunctionalInterface
public interface Predicate<T> {
    boolean test(T t);
}
