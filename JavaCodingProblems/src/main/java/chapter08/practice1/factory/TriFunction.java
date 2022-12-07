package chapter08.practice1.factory;

public interface TriFunction<T, U, V, R> {
    R apply(T t, U u, V v);
}
