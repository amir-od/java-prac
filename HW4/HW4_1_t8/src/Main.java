public class Main {
    public static void main(String[] args) {
        System.out.println("");
    }
}
abstract class Shape {
    protected String color;
    protected boolean filled;
    public Shape() {}
    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public boolean isFilled() {
        return filled;
    }
    public void setFilled(boolean filled) {
        this.filled = filled;
    }
    abstract double gerArea();
    abstract double getPerimeter();
    @Override
    public String toString() {
        return "Shape{" +
                "color='" + color + '\'' +
                ", filled=" + filled +
                '}';
    }
}
class Circle extends Shape{
    protected double radius;
    public Circle() {
    }
    public Circle(double radius) {
        this.radius = radius;
    }
    public Circle(String color, boolean filled, double radius) {
        super(color, filled);
        this.radius = radius;
    }
    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
    @Override
    double getPerimeter() {
        return 0;
    }
    @Override
    double gerArea() {
        return 0;
    }
    @Override
    public String toString() {
        return super.toString();
    }
}
class Rectangle extends Shape{
    protected  double width;
    protected double length;
    public Rectangle() {
    }
    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }
    public Rectangle(String color, boolean filled, double width, double length) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }
    public double getWidth() {
        return width;
    }
    public void setWidth(double width) {
        this.width = width;
    }
    public double getLength() {
        return length;
    }
    public void setLength(double length) {
        this.length = length;
    }
    @Override
    double getPerimeter() {
        return 0;
    }
    @Override
    double gerArea() {
        return 0;
    }
    @Override
    public String toString() {
        return super.toString();
    }
}
class Square extends Rectangle{
    public double side;
    public Square() {}
    public Square(double side) {}
    public Square(String color, boolean filled, double side) {}
    public double getSide() {
        return side;
    }
    public void setSide(double side) {
        this.side = side;
    }
    @Override
    public void setWidth(double width) {
        super.setWidth(width);
    }
    @Override
    public void setLength(double length) {
        super.setLength(length);
    }
    @Override
    public String toString() {
        return super.toString();
    }
}