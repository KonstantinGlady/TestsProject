package chapter08.decorator.lambda;

public class Cake {

    private String decorations;

    public Cake() {
    }

    public Cake(String decorations) {
        this.decorations = decorations;
    }

    public Cake decorate(String decoration) {
        return new Cake(getDecorations() + decoration);
    }

    public String getDecorations() {
        return decorations;
    }
}
