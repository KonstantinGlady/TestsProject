package patterns.chain.of.responsibility;

public class HeaderTextProcessing extends ProcessingObject<String> {
    @Override
    public String handleWork(String s) {
        return "Raul, Maria told: " + s;
    }
}
