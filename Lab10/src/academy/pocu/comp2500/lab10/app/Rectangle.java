package academy.pocu.comp2500.lab10.app;

public class Rectangle extends Shape {
    private Point p1;
    private Point p2;

    public Rectangle(String name, Point p1, Point p2) {
        super(name);
        this.p1 = p1;
        this.p2 = p2;
    }
}
