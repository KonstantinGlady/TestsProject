package chapter08.practice4.functions;

@FunctionalInterface
public interface Predicate<T> {
    boolean test(T t);
}
