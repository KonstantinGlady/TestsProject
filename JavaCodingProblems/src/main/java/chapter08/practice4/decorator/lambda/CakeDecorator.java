package chapter08.practice4.decorator.lambda;

import java.util.function.Function;
import java.util.stream.Stream;

@SuppressWarnings("unchecked")
public class CakeDecorator {

    private Function<Cake, Cake> decorator;

    public CakeDecorator(Function<Cake, Cake>... decorations) {
        reduceDecorations(decorations);
    }

    public Cake decorate(Cake cake) {
        return decorator.apply(cake);
    }

    private void reduceDecorations(Function<Cake, Cake>... decorations) {
        decorator = Stream.of(decorations)
                .reduce(Function.identity(), Function::andThen);
    }
}