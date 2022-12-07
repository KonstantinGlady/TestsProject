package chapter08.practice4.factory;

public interface TriFunction<T, U, V, R> {
    R accept(T t, U u, V v);
}
