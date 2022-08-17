package chapter02.iae;

import java.util.function.Supplier;

public final class MyObjects {

    private MyObjects() {
        throw new AssertionError("you cannot instantiate");
    }

    public static <T> T requireNonNullElseThrowIAE(T obj, String message) {
        if (obj == null) {
            throw new IllegalArgumentException(message);
        }
        return obj;
    }

    public static <T> T requireNonNullElseThrowIAE(T obj, Supplier<String> messageSupplier) {
        if (obj == null) {
            throw new IllegalArgumentException(messageSupplier == null ? null : messageSupplier.get());
        }
        return obj;
    }

    public static <T, X extends Throwable> T requireNonNullElseThrow(T obj, X exception) throws X {
        if (obj == null) {
            throw exception;
        }
        return obj;
    }

    public static <T, X extends Throwable> T requireNotNullElseThrow(T obj,
                                                                     Supplier<? extends X> exception) throws X {
        if (obj != null) {
            return obj;
        } else {
            throw exception.get();
        }
    }

}
