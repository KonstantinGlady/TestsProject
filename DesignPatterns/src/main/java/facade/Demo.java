package facade;

public class Demo {
    public static void main(String[] args) {

        Line lineA = new Line(new Point(2, 4), new Point(5, 7));
        lineA.move(-2, -4);
        System.out.println("after move: " + lineA);
        lineA.rotate(45);
        System.out.println("after rotate: " + lineA);
    }
}
