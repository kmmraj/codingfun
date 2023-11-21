package com.test.sealedclass;
//In this example:
//
//Shape is a sealed abstract class that serves as the base class for different types of shapes.
//permits Circle, Rectangle, Triangle specifies that only the Circle, Rectangle, and Triangle classes are allowed
// to extend the Shape class.
//Circle, Rectangle, and Triangle are concrete classes that extend the Shape class.
// Circle and Triangle are declared as final, meaning they cannot be further subclassed.
// Rectangle is declared as non-sealed, which means it can be subclassed by other classes.
public abstract sealed class Shape permits Circle, Rectangle, Triangle {
    // Common properties and methods for all shapes
    public abstract double area();
}

