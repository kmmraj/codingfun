package com.test.designpattern;

// Element interface
interface Shape {
    void accept(ShapeVisitor visitor);
}

// Concrete element 1: Circle
class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public void accept(ShapeVisitor visitor) {
        visitor.visitCircle(this);
    }
}

// Concrete element 2: Rectangle
class Rectangle implements Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public void accept(ShapeVisitor visitor) {
        visitor.visitRectangle(this);
    }
}

// Visitor interface
interface ShapeVisitor {
    void visitCircle(Circle circle);
    void visitRectangle(Rectangle rectangle);
}

// Concrete visitor 1: AreaCalculator
class AreaCalculator implements ShapeVisitor {
    @Override
    public void visitCircle(Circle circle) {
        double area = Math.PI * Math.pow(circle.getRadius(), 2);
        System.out.println("Area of circle: " + area);
    }

    @Override
    public void visitRectangle(Rectangle rectangle) {
        double area = rectangle.getWidth() * rectangle.getHeight();
        System.out.println("Area of rectangle: " + area);
    }
}

// Concrete visitor 2: PerimeterCalculator
class PerimeterCalculator implements ShapeVisitor {
    @Override
    public void visitCircle(Circle circle) {
        double perimeter = 2 * Math.PI * circle.getRadius();
        System.out.println("Perimeter of circle: " + perimeter);
    }

    @Override
    public void visitRectangle(Rectangle rectangle) {
        double perimeter = 2 * (rectangle.getWidth() + rectangle.getHeight());
        System.out.println("Perimeter of rectangle: " + perimeter);
    }
}

// Client code
public class VisitorPatternExample {
    public static void main(String[] args) {
        Shape circle = new Circle(5);
        Shape rectangle = new Rectangle(4, 6);

        // Create concrete visitors
        ShapeVisitor areaCalculator = new AreaCalculator();
        ShapeVisitor perimeterCalculator = new PerimeterCalculator();

        // Apply visitors to shapes
        circle.accept(areaCalculator);
        circle.accept(perimeterCalculator);

        rectangle.accept(areaCalculator);
        rectangle.accept(perimeterCalculator);
    }
}

