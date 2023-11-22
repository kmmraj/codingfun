package com.test.designpattern;

public class SOLIDDesignPrinciplesExample {

}

// Example violating SRP
class EmployeeViolation {
    void calculatePay() {
        // Calculate employee pay
    }

    void save() {
        // Save employee data to the database
    }
}
//In the above example, the Employee class has both the responsibility of calculating pay
//and saving data to the database. It would be better to split these responsibilities into separate classes.

class Employee {
    void calculatePay() {
        // Calculate employee pay
    }
}

class EmployeeRepository {
    void save(Employee employee) {
        // Save employee data to the database
    }
}

//Open/Closed Principle (OCP):
//Software entities (classes, modules, functions, etc.) should be open for extension but closed for modification.

//Example violating OCP
// Example violating OCP
class RectangleViolation {
    int width;
    int height;
}

class AreaCalculatorViolation {
    int calculateArea(RectangleViolation rectangle) {
        return rectangle.width * rectangle.height;
    }
}

//In the above example, if you want to add a new shape (e.g., Circle),
// you would need to modify the AreaCalculator class.
// Instead, use abstraction and polymorphism to make it open for extension.

interface ShapeClosed {
    int calculateArea();
}

final class RectangleClosed implements ShapeClosed {
    int width;
    int height;

    @Override
    public int calculateArea() {
        return width * height;
    }
}

final class CircleClosed implements ShapeClosed {
    int radius;

    @Override
    public int calculateArea() {
        return (int) (Math.PI * radius * radius);
    }
}

class AreaCalculatorClosed {
    int calculateArea(ShapeClosed shape) {
        return shape.calculateArea();
    }
}
//Liskov Substitution Principle (LSP):
//Subtypes must be substitutable for their base types without altering the correctness of the program.

//Example violating LSP

class RectangleLSP {
    int width;
    int height;

    int calculateArea() {
        return width * height;
    }
}

class SquareLSP extends RectangleLSP {
    @Override
    int calculateArea() {
        return width * width;
    }
}

class LSPExample {
    static void calculateArea(RectangleLSP rectangle) {
        rectangle.width = 5;
        rectangle.height = 4;
        System.out.println(rectangle.calculateArea());
    }

    public static void main(String[] args) {
        RectangleLSP rectangle = new RectangleLSP();
        calculateArea(rectangle);

        RectangleLSP square = new SquareLSP();
        calculateArea(square);
    }
}
//In the above example, the Square class is a subtype of the Rectangle class.
// However, the calculateArea() method in the Square class does not behave as expected.
// This violates the LSP because the Square class is not substitutable for the Rectangle class.
// Example violating LSP
class Bird {
    void fly() {
        // Fly
    }
}

class PenguinViolates extends Bird {
    @Override
    void fly() {
        // Can't fly, violates LSP
    }
}

//In the above example, a Penguin is a subtype of Bird but cannot fly, violating the expected behavior of the base type.
// To fix this, you might consider creating a separate hierarchy for non-flying birds.

interface BirdInterface {
    void fly();
}

class FlyingBird implements BirdInterface {
    @Override
    public void fly() {
        // Fly
    }
}

class Penguin implements BirdInterface {
    @Override
    public void fly() {
        // Do nothing, valid for penguins
    }
}

//nterface Segregation Principle (ISP):
//A class should not be forced to implement interfaces it does not use.
// In other words, a class should not be forced to depend on interfaces it does not use.

// Example violating ISP
interface Worker {
    void work();

    void eat();
}

class RobotViolates implements Worker {
    @Override
    public void work() {
        // Do some work
    }

    @Override
    public void eat() {
        // Do nothing, violates ISP
    }
}


//In the above example, the Robot class is forced to implement the eat() method,
// even though it does not need it.
// This violates the ISP because the Robot class is forced to depend on an interface it does not use.


interface Workable {
    void work();
}

interface Eatable {
    void eat();
}

class RobotCorrect implements Workable {
    @Override
    public void work() {
        // Do some work
    }
}

class SuperWorker implements Workable, Eatable {
    @Override
    public void work() {
        // Do some work
    }

    @Override
    public void eat() {
        // Eat some food
    }
}

//Dependency Inversion Principle (DIP):
//High-level modules should not depend on low-level modules.
// Both should depend on abstractions.
// In addition, abstractions should not depend on details.
// Details should depend on abstractions.


// Example violating DIP
class LightBulbViolation {
    void turnOn() {
        // Turn on the light bulb
    }
}

class SwitchViolation {
    LightBulb bulb;

    SwitchViolation(LightBulb bulb) {
        this.bulb = bulb;
    }

    void operate() {
        bulb.turnOn();
    }
}

//In the above example, the Switch class depends on the concrete implementation (LightBulb).
// Instead, depend on abstractions.

interface Switchable {
    void turnOn();
}

class LightBulb implements Switchable {
    @Override
    public void turnOn() {
        // Turn on the light bulb
    }
}

class Switch {
    Switchable device;

    Switch(Switchable device) {
        this.device = device;
    }

    void operate() {
        device.turnOn();
    }
}








