package chapter04;

import java.util.Arrays;

public final class ImmutableArray<T> {

    private final T[] array;

    private ImmutableArray(T[] array) {
        this.array = Arrays.copyOf(array, array.length);
    }

    public static <T> ImmutableArray<T> from(T[] array) {
        return new ImmutableArray<>(array);
    }

    public T get(int i) {
        return this.array[i];
    }

    public String toString() {
        return Arrays.toString(array);
    }
}
