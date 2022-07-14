package patterns.chain.of.responsibility;

public class SpellCheckerProcessing extends ProcessingObject<String> {
    @Override
    public String handleWork(String s) {
        return s.replaceAll("lamda", "lambda");
    }
}
