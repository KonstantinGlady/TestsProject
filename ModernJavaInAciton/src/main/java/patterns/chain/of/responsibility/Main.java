package patterns.chain.of.responsibility;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Main {

    public static void main(String[] args) {

        ProcessingObject<String> po1 = new HeaderTextProcessing();
        ProcessingObject<String> po2 = new SpellCheckerProcessing();
        po1.setSuccessor(po2);
        String result = po1.handle("lamda is awesome!");
        System.out.println(result);

        //lambda
        UnaryOperator<String> headerTextProcessing = (String s) -> "Raul, Maria told: " + s;
        UnaryOperator<String> spellCheckerProcessing = (String s) -> s.replaceAll("lamda", "lambda");
        Function<String, String> pipeline = headerTextProcessing.andThen(spellCheckerProcessing);
        String result2 = pipeline.apply("lamda is awesome!");
        System.out.println(result2);
    }
}
