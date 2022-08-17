package chapter02.immutable;

public class Main {
    public static void main(String[] args) {

        Radius r = new Radius();
        r.setStart(33);
        r.setEnd(22);
        Point p1 = new Point(23.2, 42.1, r);
        //even if class Point fully immutable , radius is. so you can change Point as well
        System.out.println(p1.getRadius().getStart());
        r.setStart(4);
        System.out.println(p1.getRadius().getStart());

        //you have a clone of radius, so you can't change it
        Radius r2 = new Radius();
        r2.setStart(33);
        r2.setEnd(22);
        Point2 p2 = new Point2(22.2, 33.3, r2);
        System.out.println(p2.getRadius().getStart());
        r2.setStart(3);
        System.out.println(p2.getRadius().getStart());
        //even through getter
        p2.getRadius().setStart(3);
        System.out.println(p2.getRadius().getStart());
    }
}
